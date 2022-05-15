package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Asiakas;

	/**
	 * AsiakasJdbcDao-luokka toteuttaa AsiakasDao-rajapinnan palvelut
	 * 
	 * Asiakas-tietokantataulun käsittelypalvelut kuten
		 * findAll() - hae kaikki asiakkaat tietokannasta
		 * findById() - todo: hae yhden asiakkaan tiedot annetulla asiakasid:llä
		 * addAsiakas() - lisää asiakas tietokantaan
		 * updateAsiakas() - todo: päivitä asiakkaan tiedot tietokantaan
		 * removeAsiakas() - poista asiakkaan tiedot tietokannasta
	 *
	 */

	public class AsiakasJdbcDao implements AsiakasDao {
		
		
		/**
		 * Hakee tietokannan taulusta kaikki asiakkaat ja luo ja palauttaa tiedot Asiakas-tyyppisten olioiden listana (ArrayList) 
		 * 
		 * @return ArrayList<Asiakas> Lista asiakkaat
		 */
		public List<Asiakas> findAll() {	
			Connection connection = null;  // tietokantayhteys
			PreparedStatement statement = null;  // sql-lause
			ResultSet resultset = null;   // select-lauseen tulostaulu
			List<Asiakas> asiakkaat = new ArrayList<Asiakas>();  // tyhjä asiakaslista
			Asiakas asiakas = null; 
			try {
				// Luodaan yhteys
				connection = Database.getDBConnection();
				// Luodaan komento: haetaan kaikki rivit asiakas-taulusta
				String sqlSelect = 
						"SELECT id, firstname, lastname, birthyear, sex, streetaddress, postcode, email, bonusscore FROM customer;";
				// Valmistellaan komento:
				statement = connection.prepareStatement(sqlSelect);
				// Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
				resultset = statement.executeQuery();
				// Käydään tulostaulun rivit läpi ja luetaan readAsiakas()-metodilla:
				while (resultset.next()) {
					asiakas = createAsiakasObjectFromRow(resultset);
					// lisätään asiakas listaan
					asiakkaat.add(asiakas);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(resultset, statement, connection); // Suljetaan
			}
		
			return asiakkaat;
		}
		
		
		
		/**
		 * Lukee kyselyn tulostaulusta yhdeltä aktiiviseltä tietoriviltä (asiakkaan tiedot). 
		 * Luo ja palauttaa tietojen perusteella Asiakas-tyyppisen olion
		 * 
		 * @param resultset
		 *            tietokannasta kyselyllä haettu tulostaulu
		 * @return Asiakas asiakas-olio
		 */
		private Asiakas createAsiakasObjectFromRow(ResultSet resultset) {	
			try {
				// Haetaan yhden asiakkaan tiedot kyselyn tulostaulun (ResultSet-tyyppinen resultset-olion) aktiiviselta tietoriviltä
				int id = resultset.getInt("id");
				String etunimi = resultset.getString("firstname");
				String sukunimi = resultset.getString("lastname");
				int syntymavuosi = resultset.getInt("birthyear");
				String sukupuoli = resultset.getString("sex");
				String katuosoite = resultset.getString("streetaddress");
				String postinro = resultset.getString("postcode");
				String email = resultset.getString("email");
				double bonuspisteet = resultset.getDouble("bonusscore");
			
			// Luodaan ja palautetaan uusi Asiakas-luokan olio
				return new Asiakas(id, etunimi, sukunimi, syntymavuosi, sukupuoli, katuosoite, postinro, email, bonuspisteet);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}



		/**
		 * Lisää asiakkaan tiedot tietokantaan
		 * 
		 * @param asiakas
		 *           Asiakas-luokan olio
		 */
		
		public boolean addAsiakas(Asiakas asiakas)  {
			Connection connection = null;
			PreparedStatement stmtInsert = null;
			boolean updateSuccessed = false; 

			try {
				// Luodaan tietokantayhteys
				connection = Database.getDBConnection();
				// Luodaan komento: luodaan uusi asiakas tietokannan tauluun
				String sqlInsert = 
						"INSERT INTO customer (firstname, lastname, birthyear, sex, streetaddress, postcode, email, bonusscore) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				// Valmistellaan komento:
				stmtInsert = connection.prepareStatement(sqlInsert);
				// Asetetaan parametrisoidun komennon parametrit yksi kerrallaan 
		        // customer-taulussa id-sarake auto_increment-tyyppinen, joten ei mukana insertissä
				stmtInsert.setString(1, asiakas.getEtunimi());
				stmtInsert.setString(2, asiakas.getSukunimi());
				stmtInsert.setInt(3, asiakas.getSyntymavuosi());
				stmtInsert.setString(4, asiakas.getSukupuoli());
				stmtInsert.setString(5, asiakas.getKatuosoite());
				stmtInsert.setString(6, asiakas.getPostinro());
				stmtInsert.setString(7, asiakas.getEmail());
				stmtInsert.setDouble(8, asiakas.getBonuspisteet());
				//Lähetetään INSERT-komento suoritettavaksi tietokantapalvelimelle
				int rowAffected = stmtInsert.executeUpdate();
				if (rowAffected == 1) updateSuccessed = true;
				
			} catch (SQLException e) {
				e.printStackTrace(); // consoleen näkyviin Exception-tilanteen tarkemmat tiedot vianjäljitystä varten
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(stmtInsert, connection); // Suljetaan statement ja yhteys
			}
			return updateSuccessed;
		}
		

		/**
		 * Poistaa asiakkaan tiedot tietokannasta
		 * 
		 * @param asiakasId
		 *            poistettavan asiakkaan id-arvo
		 */
		
		public boolean removeAsiakas(int asiakasId) {
			Connection connection = null;
			PreparedStatement stmtDelete = null;
			boolean updateSuccessed = false;

			try {
				// Luodaan tietokantayhteys
				connection = Database.getDBConnection();
				//Poistetaan henkilo tietokantasta:
				String sql = "DELETE FROM customer WHERE id = ?";
				stmtDelete = connection.prepareStatement(sql);
				// Asetetaan parametrisoidun delete-komennon parametri 
				stmtDelete.setInt(1, asiakasId);
				//Lähetetään DELETE-komento suoritettavaksi tietokantapalvelimelle
				int rowAffected = stmtDelete.executeUpdate();
				if (rowAffected == 1) updateSuccessed = true;
				
			} catch (SQLException e) {
				e.printStackTrace(); // consoleen näkyviin Exception-tilanteen tarkemmat tiedot vianjäljitystä varten
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(stmtDelete, connection); // Suljetaan statement ja yhteys
			}
			return updateSuccessed;
		}


		

		
		
		
	}

