function coseAlter() {
  $('#content').on('click', '.modificaPartita', function(){

        $('#content').html('');
    const id = $(this).attr('data-id')
    adminDettaglioPartita(id,true);
  });
  $('#content').on('click', '.modificaSquadra', function(){

        $('#content').html('');
    const key = $(this).attr('key')
    adminDettaglioSquadra(key,true);
  });
  $('#content').on('click', '.modificaGiocatore', function(){

        $('#content').html('');
    const id = $(this).attr('data-id')
    adminDettaglioGiocatore(id,true);
  });
}

function modificaPartita(id){
	let partita = `{
"id": ${id},
"dataincontro":`+ $('#dataincontro').children("input.titoloSpan").val()+`,
"durata":`+ $('#durata').children("input.titoloSpan").val()+`,
"possessoCasa":`+ $('#possessoCasa').children("input.titoloSpan").val()+`,
    "tiriCasa":`+ $('#tiriCasa').children("input.titoloSpan").val()+`,
    "paliCasa":`+ $('#paliCasa').children("input.titoloSpan").val()+`,
    "gialliCasa":`+ $('#gialliCasa').children("input.titoloSpan").val()+`,
    "rossiCasa":`+ $('#rossiCasa').children("input.titoloSpan").val()+`,
    "punizioniCasa":`+ $('#punizioniCasa').children("input.titoloSpan").val()+`,
    "rigoriCasa":`+ $('#rigoriCasa').children("input.titoloSpan").val()+`,
    "tiriOspite":`+ $('#tiriOspite').children("input.titoloSpan").val()+`,
    "paliOspite":`+ $('#paliOspite').children("input.titoloSpan").val()+`,
    "gialliOspite":`+ $('#gialliOspite').children("input.titoloSpan").val()+`,
    "rossiOspite":`+ $('#rossiOspite').children("input.titoloSpan").val()+`,
    "punizioniOspite":`+ $('#punizioniOspite').children("input.titoloSpan").val()+`,
    "rigoriOspite":`+ $('#rigoriOspite').children("input.titoloSpan").val()+`
}`;

$.ajax( {
    url: `admin/modifica/partite`,
    type: 'PUT',
    data: JSON.stringify(partita),
    success: function (res) {
      console.log(res);
      {span3input(); $('#content').html(''); adminDettaglioPartita(id);
      }

  }
    }
   );

}

function modificaGiocatore(id){
	let giocatore = `{
"id": ${id},
"numero":`+ $('#nMaglia').children("input.titoloSpan").val()+`,
    "nome":`+ $('#nome').children("input.titoloSpan").val()+`,
    "cognome":`+ $('#cognome').children("input.titoloSpan").val()+`,
    "ddn":`+ $('#ddn').children("input.titoloSpan").val()+`,
    "ruolo":`+ $('#ruolo').children("input.titoloSpan").val()+`
}`;


$.ajax( {
    url: `admin/modifica/giocatori`,
    type: 'PUT',
    data: JSON.stringify(giocatore),
    success: function (res) {
      console.log(res);
      {span3input(); $('#content').html(''); adminDettaglioGiocatore(id);
      }

  }
    }
   );
}
function modificaSquadra(nomeSquadra){
	let squadra = `{
"nome": ${nomeSquadra},
"nazione":`+ $('#nazione').children("input.titoloSpan").val()+`,
    "citta":`+ $('#citta').children("input.titoloSpan").val()+`
}`;


$.ajax( {
    url: `admin/modifica/squadre`,
    type: 'PUT',
    data: JSON.stringify(squadra),
    success: function (res) {
      console.log(res);
      {span3input(); $('#content').html(''); adminDettaglioSquadra(nomeSquadra);
      }

  }
    }
   );
		}
