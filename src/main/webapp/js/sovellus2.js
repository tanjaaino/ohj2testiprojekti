/*JavaScript-koodi hakee REST-rajapinnasta asiakkaiden tiedot ja tuottaa asiakasrivit
web-sivulle ohjelmallisesti */

async function lataaJaNaytaAsiakkaat(){

try{
    let response = await fetch("/api/asiakkaat", {method : 'GET'});
    let asiakkaat = await response.json();
    console.log(asiakkaat);
    // asiakas-rivien muodostus
    let asiakaslistaus = document.getElementById("asiakaslistaus");
    let asiakasriviTemplate = document.getElementById("asiakasrivi-template");
    
    for (let asiakas of asiakkaat){
    	let uusiAsiakasNode = document.importNode(asiakasriviTemplate.content, true);
    	uusiAsiakasNode.querySelector(".etunimi").innerText = asiakas.etunimi;
    	uusiAsiakasNode.querySelector(".sukunimi").innerText = asiakas.sukunimi;
    	asiakaslistaus.appendChild(uusiAsiakasNode);
    }
    
}catch (error){
	console.error(error);
	alert("Tapahtui virhe. Tutki sekä selaimen console että palvelimen console.");
}    
    
}

lataaJaNaytaAsiakkaat();