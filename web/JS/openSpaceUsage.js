/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function openSpaceUsage() {
    if(openSpaceUsage.wind_sp == null){
        openSpaceUsage.wind_sp=Window({
            'option':{
                'title':'Space Usage',
                resizable: false,
                maxHeight:265,
                maxWidth:310
            },
            'content':'userSpaceUsage.jsp',
            "ajax":true
        });
    } else {
        openSpaceUsage.wind_sp.dialog( "open" );
    }
    var parameters1= {
        "operation" : "getUsersSpaceUsage"
    };
    $.ajax({
        type:'POST',
        url:"SpaceUsage", //calling servlet
        cache:false,
        data:parameters1,
        success:function(htmldat){
            //alert("Size" + htmldat );

            var allotedSpace = 2*1024;
            var usedSpace = htmldat/(1024*1024);
            var freeSpace = allotedSpace - usedSpace;
            var usedPercentage = usedSpace / allotedSpace * 100;
            var freePercentage = freeSpace / allotedSpace * 100;
            $("#allotedSpace").html(Math.round(allotedSpace*100)/100 + "MB");
            $("#usedSpace").html(Math.round(usedSpace*100)/100 + "MB");
            $("#freeSpace").html(Math.round(freeSpace*100)/100 + "MB");
            $("#usedPercent").html(Math.round(usedPercentage*100)/100 + "%");
            $("#freePercent").html(Math.round(freePercentage*100)/100 + "%");

            $("#personalSpaceUsageGraph").progressbar({
                value:((Math.round(htmldat/(1024*1024)))/allotedSpace*100 *1)/1
            });

        },
        error:function(xhr,ajaxOptions){
            alert(xhr.status + " :: " + xhr.statusText);
        }
    });
}
openSpaceUsage.wind_sp=null;