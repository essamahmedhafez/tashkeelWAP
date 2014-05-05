function check() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }

  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      if(xmlhttp.responseText == '1'){
        document.getElementById("help1").disabled = false;
        document.getElementById("help2").disabled = true;
        document.getElementById("help3").disabled = true;
      //document.getElementById("txtHint").innerHTML=xmlhttp.responseText;  
      }
      else if(xmlhttp.responseText == '2'){
           document.getElementById("help1").disabled = true;
           document.getElementById("help2").disabled = false;
           document.getElementById("help3").disabled = true;
      }
      else if (xmlhttp.responseText == '3'){
      		document.getElementById("help1").disabled = true;
      		document.getElementById("help2").disabled = true;
            document.getElementById("help3").disabled = false;
      }
    }
  }
  session_num = document.getElementById("hiddenSession_num").innerHTML;
  xmlhttp.open('GET','/hint?session_num='+session_num,true);
  xmlhttp.send();
}

setInterval(function(){
		check();
},1000);
