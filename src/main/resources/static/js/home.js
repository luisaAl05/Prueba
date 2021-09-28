
window.onload = function(){
	document.getElementById("register-form").addEventListener("submit",validarFormulario);
};


function validarFormulario(evento) {
  evento.preventDefault();
  var usuario = document.getElementById('nombre').value;
  if(usuario.length < 1) {
    alert('No has escrito nada en el usuario');
    return false;
  }
  var contraseña = document.getElementById('contraseña').value;
  var contraseñaco = document.getElementById('contraseñac').value;
  	if(contraseña != contraseñaco || contraseña.length < 1){
    	alert('Las claves no coinciden o estan vacias');
    	return;
  	}
  this.submit();
}