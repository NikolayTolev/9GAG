
function selectPosts() {
	$('#postsBtn').addClass('selected');
	$('#votedBtn').removeClass('selected');
	$('#commentedBtn').removeClass('selected');
	$('#postsTab').removeClass('tab-hidden');
	$('#votedTab').addClass('tab-hidden');
	$('#commentedTab').addClass('tab-hidden');
}

function selectVoted() {
	$('#votedBtn').addClass('selected');
	$('#postsBtn').removeClass('selected');
	$('#commentedBtn').removeClass('selected');
	$('#votedTab').removeClass('tab-hidden');
	$('#postsTab').addClass('tab-hidden');
	$('#commentedTab').addClass('tab-hidden');
}

function selectCommented() {
	$('#commentedBtn').addClass('selected');
	$('#votedBtn').removeClass('selected');
	$('#postsBtn').removeClass('selected');
	$('#commentedTab').removeClass('tab-hidden');
	$('#votedTab').addClass('tab-hidden');
	$('#postsTab').addClass('tab-hidden');
}




//$('document').ready(function(){  
//    //initialize quickflip  
//    $('#flip-container').quickFlip();  
//
//    $('#flip-navigation li a').each(function(){  
//        $(this).click(function(){  
//            $('#flip-navigation li').each(function(){  
//                $(this).removeClass('selected');  
//            });  
//            $(this).parent().addClass('selected');  
//            //extract index of tab from id of the navigation item  
//            var flipid=$(this).attr('id').substr(4);  
//            //Flip to that content tab  
//            $('#flip-container').quickFlipper({ }, flipid, 1);  
//
//            return false;  
//        });  
//    });  
//});  