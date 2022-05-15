async function lataaAsiakkaat() {
 try {
       let response = await fetch("/api/asiakkaat", {
                method: 'GET'});
       let asiakkaat = await response.json();
       
       let asiakaslistaus =  document.querySelector("#asiakaslistaus"); //document.getElementById("asiakaslistaus");
       let asiakasriviTemplate = document.querySelector("#asiakasrivi-template");
        
       for (let asiakas of asiakkaat) {
            //console.log (asiakas.etunimi);
            
            let uusiAsiakasNode = document.importNode(asiakasriviTemplate.content, true);
        	uusiAsiakasNode.querySelector('.etunimi').innerText = asiakas.etunimi;
        	uusiAsiakasNode.querySelector('.sukunimi').innerText = asiakas.sukunimi;
            asiakaslistaus.appendChild(uusiAsiakasNode);
        }
      } catch (error) {
            console.error(error);
            alert('Tapahtui virhe. Tutki selaimen consolea ja palvelimen consolea!');
      }
 }

lataaAsiakkaat();
    
    

    
