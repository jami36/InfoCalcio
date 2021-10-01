
function stampaPapere() {
  $('#content').html('papere');
}


function span2input() {
	

$('.titoloBox').each(function(i, obj) {
    $(obj).html("<input class='titoloSpan' value='"+$(obj).text()+"'>");
});
}
function span3input() {
	
	
$('.titoloBox').each(function(i, obj) {
console.log("oggetto"+obj);
$(obj).html("<span class='titoloSpan'>" +$(obj).children("input.titoloSpan").val() +"</span>");
});
}

    function sortTable(idTable, col) {
      var table, rows, switching, i, x, y, shouldSwitch;
      table = document.getElementById(idTable);
      switching = true;
      while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
          shouldSwitch = false;
          console.log("Questo � i" + i);
          x = rows[i].getElementsByTagName("TD")[col];
          y = rows[i + 1].getElementsByTagName("TD")[col];
          
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            shouldSwitch = true;
            break;
          }
        }
        if (shouldSwitch) {
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
        }
      }
    }

    function sortTableNum(idTable, col) {
      var table, rows, switching, i, x, y, shouldSwitch;
      table = document.getElementById(idTable);
      switching = true;
      while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
          shouldSwitch = false;
          x = rows[i].getElementsByTagName("TD")[col];
          y = rows[i + 1].getElementsByTagName("TD")[col];
          if (parseInt(x.innerHTML.toLowerCase()) > parseInt(y.innerHTML.toLowerCase())) {
            shouldSwitch = true;
            break;
          }
        }
        if (shouldSwitch) {
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
        }
      }
    }

    function getHome(){
        $('#content').html('');
        $(`<h1> Benvenuti nella home del nostro project work </h1>
        <h2>Ecco le ultime partite</h2>`)
        .hide()
        .appendTo($('#content'))
        .fadeIn(2000);



        $.get(`admin`, function (session){
				if(`${session.logged}`=="true") {

					adminHome();

				} else {

				  userHome();

				}
        });


    }

    function getCompetizioni(){

        $.get('competizioni', function(res){


            for(let i = 0; i < res.length; i++){
                $(`<li class="elementoScroll"><a href='javascript:getPartiteCompetizione(${res[i].id})'>${res[i].nome}</a></li>`).appendTo($('#vmenu'));
            }


        });
    }



    function getSquadreCompetizione(id){

        $('#content').html('');

        $.get(`admin`, function (session){
				if(`${session.logged}`=="true") {

					adminSquadreCompetizione(id);

				} else {

				  userSquadreCompetizione(id);

				}
        });

      }



        function getPartiteCompetizione(id){
            $('#content').html('');

            $.get(`admin`, function (session){
    				if(`${session.logged}`=="true") {

    					adminPartiteCompetizione(id);

    				} else {


    				  	userPartiteCompetizione(id);

    				}
            });


          }


          function getDettaglioPartita(id){
            $('#content').html('');
            $.get(`admin`, function (session){
    				if(`${session.logged}`=="true") {

    					adminDettaglioPartita(id,false);

    				} else {

    				  userDettaglioPartita(id);

    				}
            });
          }



          function getGolsPartita(id){
            $('#content').html('');

            $.get(`admin`, function (session){
    				if(`${session.logged}`=="true") {

    					adminGolsPartita(id);

    				} else {

    				  userGolsPartita(id);

    				}
    				
            });

            }


          function getGiocatoriPartita(idPartita) {
              $('#content').html('');
              $.get(`admin`, function (session){
    				        if(`${session.logged}`=="true") {

    					            adminGiocatoriPartita(idPartita);

    				        } else {

    				              userGiocatoriPartita(idPartita);

    				}
            });

            }


            function getDettaglioSquadra(nomeSquadra) {
              $('#content').html('');

              $.get(`admin`, function (session){
    				       if(`${session.logged}`=="true") {

    					            adminDettaglioSquadra(nomeSquadra,false);

    				        } else {

    				              userDettaglioSquadra(nomeSquadra);

    				}
            });

            }


            

              function getGiocatoriSquadra(nomeSquadra){
                $('#content').html('');

                $.get(`admin`, function (session){
    				          if(`${session.logged}`=="true") {

    					               adminGiocatoriSquadra(nomeSquadra);

    				           } else {

    				                 userGiocatoriSquadra(nomeSquadra);

    				            }
                      });

                }

          function getPartiteSquadra(nomeSquadra){
            $('#content').html('');

            $.get(`admin`, function (session){
                  if(`${session.logged}`=="true") {

                         adminPartiteSquadra(nomeSquadra);

                   } else {

                         userPartiteSquadra(nomeSquadra);

                    }
                  });
          }

          function getDettaglioGiocatore(id) {
              $('#content').html('');

              $.get(`admin`, function (session){
    				          if(`${session.logged}`=="true") {

    					               adminDettaglioGiocatore(id,false);

    				           } else {

    				                 userDettaglioGiocatore(id);

    				                   }
          });
          }

  $(document).ready(

    function() {



    $('#content').on('click', '.listaSquadre', function(){//attraverso l'id di una competizione, io ne ottengo la lista delle squadre partecipanti.
        const id = $(this).attr('data-id')
        getSquadreCompetizione(id);
    });

    $('#content').on('click', '.dettaglioPartita', function(){
        const id = $(this).attr('data-id')
        getDettaglioPartita(id);
    });

    $('#content').on('click', '.dettaglioSquadra', function(){
      const nomeSquadra = $(this).attr('key')
      getDettaglioSquadra(nomeSquadra);
    });

    $('#content').on('click', '.listaPartiteSquadra', function(){
      const nomeSquadra = $(this).attr('key')
      getPartiteSquadra(nomeSquadra);
    });
    $('#content').on('click', '.listaGols', function(){
      const id = $(this).attr('data-id')
      getGolsPartita(id);
    });
    $('#content').on('click', '.listaPartite', function(){
      const id = $(this).attr('data-id')
      getPartiteCompetizione(id);
    });

    $('#content').on('click', '.listaGiocatoriPartita', function(){
      const id = $(this).attr('data-id')
      getGiocatoriPartita(id);
    });

    $('#content').on('click', '.listaGiocatoriSquadra', function(){
                      const nomeSquadra = $(this).attr('key')
                      getGiocatoriSquadra(nomeSquadra);
                  });


                                $('#content').on('click', '.dettaglioGiocatore', function(){
                                    const id = $(this).attr('data-id')
                                    getDettaglioGiocatore(id);
                                });

      getHome();
      getCompetizioni();
      coseAdmin();
      coseAlter();


  });
