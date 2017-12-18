var myVueapp = new Vue({
    el:"#content"
    ,data:{
    	datalist:[{id:1, color:"white"}]
    }
    ,methods:{
    	// 1行追加
        addList:function(){
            this.datalist.push({id:this.datalist.length+1, color:'white'});
        }
    	// POST処理 datalistをそのまま投げる
    	,postlist(){
    		$.ajax({url:'/post'
    			,type:"post"
    			,data:JSON.stringify(this.datalist)
    			,contentType: 'application/json'});
        }
    	// GET処理 受け取ったJSONをそのままdatalistに入れる
        ,getlist(){
        	var self=this;
            $.get('/get'
    		,null
            ,function(data){self.datalist=data}
            );
        }
    }
})