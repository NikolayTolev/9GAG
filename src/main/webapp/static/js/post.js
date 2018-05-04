
var m=document.getElementById('simpleModel');
var closeBtn=document.getElementsByClassName('closeBtn')[0];
closeBtn.addEventListener('click',closeModel)
window.addEventListener('click',clickOutside);

function ajax_get(url, callback) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log('responseText:' + xmlhttp.responseText);
            try {
                var data = JSON.parse(xmlhttp.responseText);
            } catch(err) {
                console.log(err.message + " in " + xmlhttp.responseText);
                return;
            }
            callback(data);
        }
    };
 
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function openModel(postId){
	ajax_get('/9gag.com/post/'+postId, function(post) {
		 var title=document.getElementById("title");
		 title.textContent=post.title;
	     var pic=document.getElementById("pic");
	     pic.setAttribute("src",post.imageURL);
	     m.style.display="block";
	});

 }

function closeModel(){
   m.style.display ='none';
}

function clickOutside(e){
    if(e.target==m){
    m.style.display ='none';
    }
 }


var box=document.getElementsByClassName("col-sm-8 text-left")[0];

function viewSection(){
    var data = JSON.parse(xmlhttp.responseText);
    document.write(4555);
}
