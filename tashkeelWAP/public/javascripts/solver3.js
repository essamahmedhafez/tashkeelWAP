function checkThirdHint() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp3=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp3=new ActiveXObject("Microsoft.XMLHTTP");
  }

  xmlhttp3.onreadystatechange=function() {
    if (xmlhttp3.readyState==4 && xmlhttp3.status==200) {
      if (xmlhttp3.readyState==4 && xmlhttp3.status==200) {
        xmlhttp3.responseText;
        if(xmlhttp3.responseText != "0"){
          var button = document.getElementById("thirdHint");
          button.setAttribute("data-content",xmlhttp3.responseText); 
        }
      }
    }
  }
  session_num = document.getElementById("hiddenSession_num").innerHTML;
  xmlhttp3.open('GET','/solve3?session_num='+session_num,true);
  xmlhttp3.send();
}
  

setInterval(function(){
    checkThirdHint();
},1000);
