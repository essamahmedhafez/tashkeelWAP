function checkFirstHint() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp1=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp1=new ActiveXObject("Microsoft.XMLHTTP");
  }

  xmlhttp1.onreadystatechange=function() {
    if (xmlhttp1.readyState==4 && xmlhttp1.status==200) {
      if (xmlhttp1.readyState==4 && xmlhttp1.status==200) {
        xmlhttp1.responseText;
        if(xmlhttp1.responseText != "0"){
          var button = document.getElementById("firstHint");
          button.setAttribute("data-content",xmlhttp1.responseText); 
        }
      }
    }
  }
  session_num = document.getElementById("hiddenSession_num").innerHTML;
  xmlhttp1.open('GET','/solve1?session_num='+session_num,true);
  xmlhttp1.send();
}

setInterval(function(){
		checkFirstHint();
},1000);
