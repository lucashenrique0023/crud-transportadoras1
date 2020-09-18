function filtrarEstado(estado){
	
	document.getElementById("inputSearchEstado").value = estado;
	document.getElementById("formFilter").submit();
}

function filtrarCidade(cidade){
	
	document.getElementById("inputSearchCidade").value = cidade;
	document.getElementById("formFilter").submit();
}

function filtrarModal(modal){
	
	document.getElementById("inputSearchModal").value = modal;
	document.getElementById("formFilter").submit();
}

function filtrarNome(nome){
	document.getElementById("inputSearchNome").value = nome;
	document.getElementById("formFilter").submit();
}

function enviarFormulario(){
	document.getElementById("formFilter").submit();
}


