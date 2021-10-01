
	function adminHome() {
	  $.get('partite', function (res){
		console.log(res);
		console.log(res[0].casa);
	  var tabella=`<table id='partite' class="c6">
	        <thead>
	        <tr>
					<th> <button onclick="sortTableNum('partite',0)">Data</button></th>
	        <th><button onclick="sortTable('partite',1)">Squadra Casa</button></th>
	        <th><button onclick="sortTable('partite',2)">Squadra Trasferta</button></th>
	        <th><button onclick="sortTable('partite',3)">Competizione</button></th>
	        <th>Risultato<th>
	        </tr>
	        </thead>
	        <tbody>`;



	    for(let i = 0; i < res.length; i ++){
	        tabella += `
	        <tr>
					<td >${res[i].dataincontro}</td>
	        <td class='dettaglioSquadra clickabile' key='${res[i].casa}'>${res[i].casa}</td>
	        <td class='dettaglioSquadra clickabile' key='${res[i].ospite}'>${res[i].ospite}</td>
	        <td>${res[i].competizione}</td>
	        <td class='dettaglioPartita clickabile' data-id='${res[i].id}'>${res[i].risultato}</td>
					<td><button class='modificaPartita' data-id='${res[i].id}'>\u270E</button></td>
	        <td>
	            <button class="listaGiocatoriPartita" data-id="${res[i].id}"> Lista giocatori </button>
	        </td>
	        <td>
	            <button class="listaGols" data-id="${res[i].id}"> Lista goal </button>
	        </td>
	        </tr>
	        `;
	    }
	tabella += `</tbody></table>`;

	$(tabella).appendTo($('#content'));

	});
	}

	function adminSquadreCompetizione(id) {
	  $.get('squadre/competizioni/'+id+'/', function (res){

	      var table =`<table id='p'>
	      <thead>
	      		<tr>
	          <th><button onclick="sortTable('p',0)">Nome</th>
	          </tr>
	      </thead>
	      <tbody>`;

	      for(let squadra in res){
	          table += `
	          <tr>
	          <td>${squadra.nome}</td>
	          <td>
	              <button class="dettaglioSquadra" key="${squadra.nome}"> Lista partite <button>
	          </td>
						<td><button class='modificaSquadra' key='${res[i].nome}'>\u270E</button></td>
	          </tr>
	          `;
	      }

	      table += `</tbody></table>`;
	      $(table).appendTo($('#content'));
	  });
	}



	        function adminPartiteCompetizione(id){
	            $.get(`partite/${id}`, function (res){


	                var table =`<table id="p" class='c6'>
	                <thead>
	                <tr>
	                <th><button onclick="sortTableNum('p',0)">Data</th>
	                <th><button onclick="sortTable('p',1)">Squadra Casa</th>
	                <th><button onclick="sortTable('p',2)">Squadra Trasferta</th>
	                <th><button onclick="sortTable('p',3)">Competizione</th>
	                <th>Risultato<th>
	                </tr>
	                </thead>
	                <tbody>`;

	                for(let i = 0; i < res.length; i++){
	                    table += `
	                    <tr>
	                    <td>${res[i].dataincontro}</td>
	                    <td class='dettaglioSquadra clickabile' key='${res[i].casa}'>${res[i].casa}</td>
	                    <td class='dettaglioSquadra clickabile' key='${res[i].ospite}'>${res[i].ospite}</td>
	                    <td>${res[i].competizione}</td>
	                    <td class='dettaglioPartita clickabile' data-id='${res[i].id}'>${res[i].risultato}</td>
											<td><button class='modificaPartita' data-id='${res[i].id}'>\u270E</button></td>
	                    </tr>
	                    `;
	                }

	                table += `</tbody></table>`;
	                $(table).appendTo($('#content'));
	            });
	          }


	          	function adminDettaglioPartita(id,edit){
	            $.get(`partita/${id}`, function (res){

	                $(`<table class="DettaglioPartitaCSS">
                  <thead>
                    <tr>

                      <th></th>
                      <th></th>
                      <th class="dataincontro"><span class=titoloBox id="dataincontro"><span class=titoloSpan>${res.dataincontro}</span></span></th>
                      <th></th>

                    </tr>
                    <tr>

                      <th></th>
                      <th class='centraleS dettaglioSquadra centraleS clickabile' key='${res.casa}'>${res.casa}</th>
                      <th style="text-align: center;"><b class="risultato">${res.risultato}</b><br>
                      <span class=titoloBox id="durata"><span class=titoloSpan>${res.durata}</span></span></th>
                      <th class='centraleS dettaglioSquadra clickabile' key='${res.ospite}'>${res.ospite}</th>

                    </tr>
                  </thead>

                  <tbody>

                  <tr>
                  <td class="primoTD">Possesso palla</td>
                  <td><span class=titoloBox id="possessoCasa"><span class=titoloSpan>${res.possessoCasa}</span></span></td>
                  <td></td>
                  <td>${res.possessoOspite}</td>
                  </tr>
                  <tr>
                  <td class="primoTD">Tiri</td>
                  <td><span class=titoloBox id="tiriCasa"><span class=titoloSpan>${res.tiriCasa}</span></span></td>
                  <td></td>
                  <td><span class=titoloBox id="tiriOspite"><span class=titoloSpan>${res.tiriOspite}</span></span></td>
                  </tr>
                  <tr>
                  <td class="primoTD">Pali</td>
                  <td><span class=titoloBox id="paliCasa"><span class=titoloSpan>${res.paliCasa}</span></span></td>
                  <td></td>
                  <td><span class=titoloBox id="paliOspite"><span class=titoloSpan>${res.paliOspite}</span></span></td>
                  </tr>
                  <tr>
                  <td class="primoTD">Gialli</td>
                  <td><span class=titoloBox id="gialliCasa"><span class=titoloSpan>${res.gialliCasa}</span></span></td>
                  <td></td>
                  <td><span class=titoloBox id="gialliOspite"><span class=titoloSpan>${res.gialliOspite}</span></span></td>
                  </tr>
                  <tr>
                  <td class="primoTD">Rossi</td>
                  <td><span class=titoloBox id="rossiCasa"><span class=titoloSpan>${res.rossiCasa}</span></span></td>
                  <td></td>
                  <td><span class=titoloBox id="rossiOspite"><span class=titoloSpan>${res.rossiOspite}</span></span></td>
                  </tr>
                  <tr>
                  <td class="primoTD">Punizioni</td>
                  <td><span class=titoloBox id="punizioniCasa"><span class=titoloSpan>${res.punizioniCasa}</span></span></td>
                  <td><button onclick="span2input()">
					\u270E
					</button></td>
                  <td><span class=titoloBox id="punizioniOspite"><span class=titoloSpan>${res.punizioniOspite}</span></span></td>
                  </tr>
                  <tr>
                  <td class="primoTD">Rigori</td>
                  <td><span class=titoloBox id="rigoriCasa"><span class=titoloSpan>${res.rigoriCasa}</span></span></td>
                  <td><button onclick="modificaPartita(${id})">
					Conferma
					</button></td>
                  <td><span class=titoloBox id="rigoriOspite"><span class=titoloSpan>${res.rigoriOspite}</span></span></td>
                  </tr>


                  </tbody>
                  </table>
					
					`
					).appendTo('#content');

	                if (edit) { span2input();}

	            });
	          }



	          function adminGolsPartita(id){

	              $.get(`gols/partita/${id}`, function (res){
	                  var table =`<table id="p">
	                  <thead>
	                  <tr>
	                  <th><button onclick="sortTable('p',0)">Nome realizzatore</th>
	                  <th><button onclick="sortTable('p',1)">Nome assistman</th>
	                  <th>Squadra</th>
	                  <th><button onclick="sortTableNum('p',3)">Minuto</th>
	                  <th>Dettagli del gol</th>
	                  </tr>
	                  </thead>
	                  <tbody>`;

	                  for(let i = 0; i < res.length; i++){
	                      table += `
	                      <tr>
	                        <td>${res[i].realizzatore}</td>
	                        <td>${res[i].assistman}</td>
	                        <td>${res[i].nome_squadra}</td>
	                        <td>${res[i].minuto}</td>
	                        <td>${res[i].dettaglio}</td>
	                      </tr>
	                      `;
	                  }

	                  table += `</tbody></table>`;

	                  $(table).appendTo($('#content'));

	              });
	            }




	            function adminGiocatoriPartita(idPartita) {
	              $.get(`giocatori/partita/${idPartita}`, function (res) {

	                let squadra = res[0].squadra;
	                let tabR = `<table id="p" style = "float:left; margin-left:120px; margin-top:50px">
	               	<caption> ${res[0].squadra} </caption>
	                <thead>
	                <tr>
	                <th> <button onclick="sortTable('p',0)">Nome</button></th>
	                <th> <button onclick="sortTable('p',1)">Cognome</button></th>
	                <th> <button onclick="sortTable('p',2)">Ruolo</button></th>
	                </tr>
	                </thead>
	                <tbody>`;
	                let tabL = `<table id="l" style = "float:left; margin-left:100px; margin-top:50px">
	                <caption> ${res[11].squadra} </caption>
	                <thead>
	                <tr>
	                <th> <button onclick="sortTable('l',0)">Nome</button></th>
	                <th> <button onclick="sortTable('l',1)">Cognome</button></th>
	                <th> <button onclick="sortTable('l',2)">Ruolo</button></th>
	                </tr>
	                </thead>
	                <tbody>`;

	                for (var i = 0; i < res.length; i++) {
	                  if (res[i].squadra == res[0].squadra) {
	                    tabR += `<tr>
	                      <td class='dettaglioGiocatore clickabile' data-id='${res[i].id}'>${res[i].nome}</td>
	                      <td class='dettaglioGiocatore clickabile' data-id='${res[i].id}'>${res[i].cognome}</td>
	                      <td>${res[i].ruolo}</td>
	                      <td><button class='modificaGiocatore' data-id='${res[i].id}'>\u270E</button></td>
	                    </tr>`;
	                  } else {
	                    tabL += `<tr>
	                      <td class='dettaglioGiocatore clickabile' data-id='${res[i].id}'>${res[i].nome}</td>
	                      <td class='dettaglioGiocatore clickabile' data-id='${res[i].id}'>${res[i].cognome}</td>
	                      <td>${res[i].ruolo}</td>
	                      <td><button class='modificaGiocatore' data-id='${res[i].id}'>\u270E</button></td>
	                    </tr>`;
	                  }

	                }

	                tabL += "</tbody></table>";
	                tabR += "</tbody></table>";

	                $(tabL).appendTo($('#content'));
	                $(tabR).appendTo($('#content'));

	              });

	            }


	            function adminDettaglioSquadra(nomeSquadra, edit) {

	              $.get(`squadre/${nomeSquadra}`, function (res){

	                  $(`<ul>
	                    <li id="nome">Nome: ${res.nome} </li>
	                    <li>Nazione: <span class=titoloBox id="nazione"><span class=titoloSpan>${res.nazione}</span></span></li>
	                    <li >Città: <span class=titoloBox id="citta"><span class=titoloSpan>${res.citta}</span></span></li></ul>
	                    <button class="listaGiocatoriSquadra" key="${res.nome}"> Lista giocatori della squadra </button>
	                    <button class="listaPartiteSquadra" key="${res.nome}"> Lista partite della squadra </button>
											<br> <br>
											<button onclick="span2input()">
											\u270E
											</button>
											<button onclick="modificaSquadra('${nomeSquadra}')">
											Conferma
											</button>`).appendTo($('#content'));

											if (edit) span2input();

	              });

	            }


	              function adminDettaglioGiocatore(id, edit) {

	                $.get(`giocatori/${id}`, function (res){

	                    $(`<ul>
	                        <li >Numero di maglia: <span class=titoloBox id="nMaglia"><span class=titoloSpan>${res.numero}</span></span></li>
	                        <li >Nome: <span class=titoloBox id="nome"><span class=titoloSpan>${res.nome}</span></span></li>
	                        <li >Cognome: <span class=titoloBox id="cognome"><span class=titoloSpan>${res.cognome}</span></span></li>
	                        <li >Data di Nascita: <span class=titoloBox id="ddn"><span class=titoloSpan>${res.ddn}</span></span></li>
	                        <li class='dettaglioSquadra' key='${res.casa}'>Squadra: ${res.squadra}</li>
	                        <li >Ruolo: <span class=titoloBox id="ruolo"><span class=titoloSpan>${res.ruolo}</span></span></li>
	                        <li>Contratti: ${res.contratti}</li>
	                        </ul>
													<button onclick="span2input()">
													\u270E
													</button>
													<button onclick="modificaGiocatore(${id})">
													Conferma
													</button>`).appendTo($('#content'));

	                    if (edit) span2input();

	                });
	              }

	              function adminGiocatoriSquadra(nomeSquadra){

	                $.get(`giocatori/squadra/${nomeSquadra}`, function (res){

	                  var table = `<table id="table">
	                  <thead>
	                  <tr>
	                  <td><button onClick="sortTable('table',0)">Nome</button></td>
	                  <td><button onClick="sortTable('table',1)">Cognome</button></td>
	                  <td><button onClick="sortTable('table',2)">Ruolo</button></td>
	                  </tr>
	                  </thead>
	                  <tbody>`;

	                  for(let i = 0; i < res.length; i++){
	                      table += `
	                      <tr>
	                        <td class="dettaglioGiocatore clickabile" data-id="${res[i].id}">${res[i].nome}</td>
	                        <td class="dettaglioGiocatore clickabile" data-id="${res[i].id}">${res[i].cognome}</td>
	                        <td>${res[i].ruolo}</td>
	                        <td><button class='modificaGiocatore' data-id='${res[i].id}'>\u270E</button></td>
	                      </tr>
	                      `;
	                  }

	                  table += `</tbody></table>`;
	                  $(table).appendTo('#content')

	                });

	                }

	            function adminPartiteSquadra(nomeSquadra){
	              $.get(`partite/${nomeSquadra}`, function (res){


	                  var table =`<table id="p" class='c6'>
	                  <thead>
	                  <tr>
	                  <th><button onclick="sortTableNum('p',0)">Data</th>
	                  <th><button onclick="sortTable('p',1)">Squadra Casa</th>
	                  <th><button onclick="sortTable('p',2)">Squadra Trasferta</th>
	                  <th><button onclick="sortTable('p',3)">Competizione</th>
	                  <th>Risultato<th>
	                  </tr>
	                  </thead>
	                  <tbody>`;

	                  res.forEach((item, i) => {
	                    table += `
	                    <tr>
	                    <td>${res[i].dataincontro}</td>
	                    <td class='dettaglioSquadra clickabile' key='${res[i].casa}'>${res[i].casa}</td>
	                    <td class='dettaglioSquadra clickabile' key='${res[i].ospite}'>${res[i].ospite}</td>
	                    <td>${res[i].competizione}</td>
	                    <td class='dettaglioPartita clickabile' data-id='${res[i].id}'>${res[i].risultato}</td>
											<td><button class='modificaPartita' data-id='${res[i].id}'>\u270E</button></td>
	                    </tr>
	                    `;
	                  });

	                  table += `</tbody></table>`;
	                  $(table).appendTo($('#content'));
	              });
	            }
