function coseAdmin(){

    //se loggato mostra logout, se non loggato mostra pulsante che richiama la dynamic content di login
    $('#access').on('click', '.login', function(){
        login();
    });

    $('#access').on('click', '.logout', function(){
        $.get('admin/logout');
        renderLogout();  //intendo dire che controlla se è loggato, quindi dopo la disconnessione non è più loggato, quindi aggiorna il bottone.
    });

	$('#access').on('click', '.loginSubmit', function(){
		loginSubmit();
	});

    $('#content').on('click', '.caricamento', function(){

    });
console.log("sono in coseAdmin");
    loginButton();

}

function renderLogout(){
		$('#content').html('');
		setLogin();
		getHome();
}

function setLogin(){

      $('#access').html(`<button style="margin-left:100px" class="login">Login</button>`);
}
function setLogout(){

      $('#access').html(`<button style="margin-left:100px" onclick=renderINSERIMENTI()>INSERIMENTO DA FILE</button><button style="margin-left:20px" class="logout">Logout</button>`);
}

function renderINSERIMENTI() {
	$('#content').html(`<label for="tipoInserimento">Scegli il tipo di inserimento:</label>
<select name="tipoInserimento" id="tipoInserimento">
  <option value="squadre">squadre</option>
  <option value="giocatori">giocatori</option>
  <option value="competizioni">competizioni</option>
  <option value="partite">partite</option>
  <option value="gols">gols</option>
  <option value="contratti">contratti</option>
  <option value="competizionisquadre">competizionisquadre</option>
</select>
<br>
<input type="file" id="myFile">
<br>
<br>
<b>
PREVIEW
</b><span><button class="cross"onclick="cancellaFile()">x</button></span>

<p id="output" class=" scorribile"></p>
<button id=carica disabled=false onclick='caricamento()'>upload</button>
<script>
document.getElementById('myFile')
            .addEventListener('change', function() {

            var fr=new FileReader();
            fr.onload=function(){
                document.getElementById('output')
                        .textContent=fr.result;
            }

            fr.readAsText(this.files[0]);
            var x = document.getElementById("carica");
  					x.disabled = false;
        })

</script>


`);

}

function cancellaFile() {
	$("#myFile").val("");
	$("#output").text("");
	var x = document.getElementById("carica");
  					x.disabled = true;
}

function caricamento() {
        	let a = $('#output').text();
			let b = $('#tipoInserimento').val();

			switch (b) {
				case "squadre":
					$.post("admin/aggiungi/squadre",JSON.stringify(a),function(res) {
					});
					getHome();
				break;
				case "giocatori":
					$.post("admin/aggiungi/giocatori",JSON.stringify(a),function(res) {
					});
					getHome();
				break;
				case "gols":
					$.post("admin/aggiungi/gols",JSON.stringify(a),function(res) {
					});
					getHome();

				break;
				case "competizioni":
					$.post("admin/aggiungi/competizioni",JSON.stringify(a),function(res) {
					});
					getHome();

				break;
				case "partite":
					$.post("admin/aggiungi/partite",JSON.stringify(a),function(res) {
					});
					getHome();

				break;
				case "contratti":
					$.post("admin/aggiungi/contratti",JSON.stringify(a),function(res) {
					});
					getHome();

				break;
				case "competizionisquadre":
					$.post("admin/aggiungi/competizionisquadre",JSON.stringify(a),function(res) {
					});
					getHome();

				break;
			}


        }
function loginButton(){
  $.get(`admin`, function (res){  //getBool nome finto
	console.log("io sono la get del bottone:" + res.logged);
    if (`${res.logged}` == "true") {  //mostra logout
      setLogout();
    } else {      //mostra richiamaLoginForm
		setLogin();
    }
  });

  $('#access').html(`<button
    `)
}

function login(){ //questa non è solo la renderview della form?   la form effettiva è un'altra, no?
  $('#access').html(`<button style="margin-left:100px" class="loginSubmit">Login</button>
    <div style="float:right">
	<input type='text' id='username' placeholder='Username' style="margin-left:10px">
	<br><input type='password' id='password' placeholder='Password' style="margin-left:10px">
	</div><span><button class="cross"onclick="loginButton()">x</button></span>
    `);


}

function errore(){
  $('#content').html('');

  $(`<h2 style="color:red"> Credenziali errate </h2>`).appendTo('#content');

}

function loginSubmit() {

  let admin = ""+$('#password').val()+","+$('#username').val();
console.log(admin);
  $.post('admin/login', (admin), function (res){
    console.log(res);
    if (res == "true") {
      loginButton();
        $('#content').html('');
        renderINSERIMENTI();

    } else {
      errore();
    }
  })
}

function admin(){
  $('#content').html('');

  $(`<button> Aggiungi record da file </button>
      <button> Modifica record </button>
    `);
}
