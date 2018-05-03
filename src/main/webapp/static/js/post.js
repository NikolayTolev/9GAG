//get the model element
var model=document.getElementById('simpleModel');

//get the open model button
//get close button
var closeBtn=document.getElementsByClassName('closeBtn')[0];

//Listen for click

//Listen for close click

closeBtn.addEventListener('click',closeModel)
//Listen for outside click
window.addEventListener('click',clickOutside);

//func
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

//function to open model
function openModel(postId){
	ajax_get('/9gag.com/post/'+postId, function(post) {
		 var title=document.getElementById("title");
		 title.textContent=post.title;
	     var pic=document.getElementById("pic");
	     pic.setAttribute("src",post.imageURL);
	     model.style.display="block";
	     
	   
	});

 }
 

//function to close model 

function closeModel(){
   model.style.display ='none';
}

//function to close model if outside click
function clickOutside(e){
    if(e.target==model){
    model.style.display ='none';
    }
 }


var box=document.getElementsByClassName("col-sm-8 text-left")[0];

function viewSection(){
    var data = JSON.parse(xmlhttp.responseText);
    document.write(4555);
}
