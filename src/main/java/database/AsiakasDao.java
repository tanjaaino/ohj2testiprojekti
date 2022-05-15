package database;

import java.util.List;

import model.Asiakas;


	/**
	 * Asiakas-tietokohteen käsittelypalvelut:
		 * findAll() - hae kaikki asiakkaat tietokannasta
		 * findById() - todo: hae yhden asiakkaan tiedot annetulla asiakasid:llä
		 * addAsiakas() - lisää asiakas tietokantaan
		 * updateAsiakas() - todo: päivitä asiakkaan tiedot tietokantaan
		 * removeAsiakas() - poista asiakkaan tiedot tietokannasta
	 *
	 */

	public interface AsiakasDao {

		public List<Asiakas> findAll();
		
		public boolean addAsiakas(Asiakas asiakas);
		
		public boolean removeAsiakas(int asiakasId);

	}