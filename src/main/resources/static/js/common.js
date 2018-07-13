$(window).load(function() {
    	$("body").addClass("loaded");
		var cur = $(location).attr("href");
		var text = $(this).text().split('#');
		if(cur.toLowerCase().indexOf("expense") >= 0)
		{
			$(".menu__item:nth-child(1)").delay(1000).addClass("menu__item--current");
		}
		else if(cur.toLowerCase().indexOf("receipt") >= 0)
		{
			$(".menu__item:nth-child(2)").delay(1000).addClass("menu__item--current");
		}
		else if(cur.toLowerCase().indexOf("reports") >= 0)
		{
			$(".menu__item:nth-child(3)").delay(1000).addClass("menu__item--current");
		}
		else if(cur.toLowerCase().indexOf("admin") >= 0)
		{
			$(".menu__item:nth-child(4)").delay(1000).addClass("menu__item--current");
		}
		else
		{
			
		}
		 /* $(".menu__item").click(function() {
			$(".menu__item").removeClass("menu__item--current");
            $(this).delay(1000).addClass("menu__item--current");
        });*/
		
		/* grid-list */
		
		$(".reports .action .list").addClass("clicked");
		$(".reports").removeClass("grid");
		$(".reports .action .grid").click(function(){
			var $elm = $(".dataTable").addClass("checked");
			setTimeout(function() {
  $elm.removeClass("checked");
}, 300);
			
			
			if($(".status-inner span").hasClass("clicked"))
			{	
				var statusclass = $(".status-inner span.clicked").attr("class");
				if(statusclass != "")
				{
					var clsArr = 	statusclass.split(" ");
					$("span.status").parent().parent().parent().parent().parent().hide();
					$("span.status."+clsArr[0]).parent().parent().parent().parent().parent().show();
				}
			}
			
			$(".reports .action .list").removeClass("clicked");
			$(this).addClass("clicked");
			if($(".reports").hasClass("grid"))
			{
				
			}
			else
			{	
			
				$(".reports").addClass("grid");
				$(".reports.grid .cd-gallery table tbody tr").wrap("<table></table>");
				var statusclass = $(".status-inner span.clicked").attr("class");
				if(statusclass != "")
				{
					var clsArr = 	statusclass.split(" ");
					$("span.status").parent().parent().parent().parent().parent().hide();
					$("span.status." + clsArr[0]).parent().parent().parent().parent().parent().show();
				}
				
			}
			
		});
		$(".dataTable").removeClass("checked");
		$(".reports .action .list").click(function() {
			var $elm = $(".dataTable").addClass("checked");
			setTimeout(function() {
  $elm.removeClass("checked");
}, 300);
			$(".reports .action .grid").removeClass("clicked");
			$(this).addClass("clicked");
			
				$("table#example table tbody tr").unwrap();
				$("table#example table tr").unwrap();
					$(".reports").removeClass("grid");
			
		});
		
		/* ================ */
});
$(document).ready(function() {
		
	
		/* status filter */
		
			
		
		$(".status-inner span").click(function() {
			if($(this).hasClass("clicked"))
			{
				$(".status-inner span").removeClass("clicked");
				$(".grid table tbody tr").css("display","table-row");
				$("table tbody table").css("display","table");
				$("table tbody tr").css("display","table-row");
			}
			else
			{
            var statusclass = $(this).attr("class");
			$(".status-inner span").removeClass("clicked");
			$(this).addClass("clicked");
		
			if($("table tbody tr td .border").children(".status").hasClass(statusclass))
			{
				
					$(".grid table tbody tr").css("display","none");
					$("table tbody table").css("display","none");
					$(".grid ." + statusclass).parents("tr").parent("tbody").parent("table").css("display","table");
			
				
				$("table tbody tr").css("display","none");
				
				$("." + statusclass).parents("tr").css("display","table-row");
				
			}
			}
			
			
        });
		
		
		
		/* ====================== */
		
		/* panel option */
		
		$(".panel-bottom li").click(function() {
			$(".panel-bottom li").removeClass("parent-div");
            $(this).toggleClass("parent-div");
        });
		
		/* ======================== */
		
		/* Side menu animation */ 
		
		$("#open-button").click(function() {
   			 $("body").addClass("show-menu");
		});
		$("#close-button").click(function() {
             $("body").removeClass("show-menu");
        });
		
		/* ===================== */
		
		/* filter animation */
		
		$(".cd-filter-trigger").click(function() {
			$(this).addClass("filter-is-visible");
    		$(".cd-filter").addClass("filter-is-visible");
			$(".cd-gallery").addClass("filter-is-visible");
		});
		$(".cd-close").click(function() {
			$(".cd-filter-trigger").removeClass("filter-is-visible");
    		$(".cd-filter").removeClass("filter-is-visible");
			$(".cd-gallery").removeClass("filter-is-visible");
		});
		
		/* ====================== */
		
		
		 
		 /* data table */
		 
		 $(this).parents("tr").css("display","block");
    $(".more-action").click(function() {
		$(this).parent(".more-action-parent").children(".more-action-child").css("display","block");
		$(this).parent(".more-action-parent").toggleClass("more-added");
	});
	$(".more-action-child .title").click(function() {
        $(this).parents(".more-action-child").css("display","none");
		$(this).parents(".more-action-child").parents(".more-action-parent").removeClass("more-added");
    });
	 $(".add-expense-action").click(function() {
		$(this).parent(".add-expense-parent").children(".add-expense-child").css("display","block");
		$(this).parent(".add-expense-parent").toggleClass("expense-added");
	});
	$(".add-expense-child .title").click(function() {
        $(this).parents(".add-expense-child").css("display","none");
		$(this).parents(".add-expense-child").parents(".add-expense-parent").removeClass("expense-added");
    });
	$("table td").click(function() {
		 $("tr").removeClass("checked");
        $(this).parents("tr").addClass("checked");
    });
	
	$("table th .check").click(function() {
		var cou = $("table tbody tr.checked").length;
		if( cou == 1)
		{
			$("table tbody tr").addClass("checked");
		}
		else if ( cou == 0)
		{
			$("table tbody tr").addClass("checked");
		}
		else
		{
			$("table tbody tr").removeClass("checked");
		}
		
	});
	$(".remove").click(function() {
        $(this).parents("tr").css("display","none");
    });
		 
		 /* ====================== */
		 
		 /* Registration validation */
		 
	
	$(".progress-button").click(function() {
    if(($("#name").val() == 'philinwhale@gmail.com') & ( jQuery("#password").val() == '123456'))
	{
		$(".progress-button .check").addClass("answer1").show(1000);
		$(".progress-button .cross").hide();
		
	}
	else
	{
		$(".progress-button .check").hide();
		$(".progress-button .cross").addClass("answer1").show(1000);
	}
    });
	
	
		 
		 /* ======================= */
		 /* Top menu animation */
		
      
		
		
		
		
});
/* close container */
$(document).mouseup(function(e)
{
var container = $(".more-action-child");
if (!container.is(e.target) && container.has(e.target).length === 0) 
{
	container.hide();
	$(".more-action-parent").removeClass("more-added");
}
var container = $(".add-expense-child");
if (!container.is(e.target) && container.has(e.target).length === 0) 
{
	container.hide();
	$(".add-expense-parent").removeClass("expense-added");
}


});

$(document).mouseup(function(e)
{
var container1 = $(".child-div");
if (!container1.is(e.target) && container1.has(e.target).length === 0) 
{
	
	$(".parent-div").removeClass("parent-div");
	
}
});
/*================== */