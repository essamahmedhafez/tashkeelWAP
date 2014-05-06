function checkSecondHint() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp2=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
  }

  xmlhttp2.onreadystatechange=function() {
    if (xmlhttp2.readyState==4 && xmlhttp2.status==200) {
      if (xmlhttp2.readyState==4 && xmlhttp2.status==200) {
        xmlhttp2.responseText;
        if(xmlhttp2.responseText != "0"){
          var button = document.getElementById("secondHint");
          button.setAttribute("data-content",xmlhttp2.responseText); 
        }
      }
    }
  }
  session_num = document.getElementById("hiddenSession_num").innerHTML;
  xmlhttp2.open('GET','/solve2?session_num='+session_num,true);
  xmlhttp2.send();
}

setInterval(function(){
    checkSecondHint();
},1000);
