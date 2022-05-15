package control;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.AsiakasDao;
import database.AsiakasJdbcDao;
import model.Asiakas;

@WebServlet("/api/asiakkaat")

/*
 * REST-metodeita Asiakkaat-tietoresurssiin liittyen. Endpoint + HttpMethod +
 * (Action) konvention mukaisia: 
 * /api/asiakkaat + GET (kaikki asiakkaat)
 * /api/asiakkaat/{id} + GET (yksi asiakas id-arvon perusteella) 
 * /api/asiakkaat + POST (lisää uusi asiakas) 
 * /api/asiakkaat + DELETE (poista asiakas) 
 * /api/asiakkaat + PUT (muokkaa asiakas)
 */
public class AsiakkaatRESTServlet extends HttpServlet {

	/**
	 * REST-metodi, endpoint: /api/asiakkaat, method: GET, action: hae kaikki asiakkaat
	 * 
	 * Lähettää selaimelle tietokannasta haetut kaikki asiakkaat JSON-muodossa
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AsiakasDao asiakasdao = new AsiakasJdbcDao();
			List<Asiakas> asiakkaat = asiakasdao.findAll();
			
			// asiakaslista json-muotoon
			String jsonAsiakkaat = new Gson().toJson(asiakkaat);
			response.setContentType("application/json;charset=UTF-8");
			
			response.getWriter().println(jsonAsiakkaat);
		} catch (IOException e) {
			// TODO 
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			AsiakasDao asiakasdao = new AsiakasJdbcDao();
			List<Asiakas> asiakkaat = asiakasdao.findAll();
			
			String strJson = new Gson().toJson(asiakkaat);
			System.out.println(strJson);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().println(strJson);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	*/
}

	