methods: {
      init: function () {
            if(typeof(WebSocket) === "undefined"){
                alert("您的浏览器不支持socket")
            }else{
                // 实例化socket
                this.socket = new WebSocket("ws://localhost:8086/socketServer/tom")
                // 监听socket连接
                this.socket.onopen = this.open
                // 监听socket错误信息
                this.socket.onerror = this.error
                // 监听socket消息
                this.socket.onmessage = this.getMessage
            }
      },
      open: function () {
          console.log("socket连接成功")
      },
      error: function () {
          console.log("连接错误")
      },
      getMessage: function (msg) {
          console.log(msg.data)
          // this.messages.pop(); //删除并返回最后一个元素
          // this.messages.shift();  //删除并返回第一个元素
          // this.messages.unshift();//在一个元素前加一个
          // this.messages.push();   //在最后加一个
      },
      send: function (params) {
          this.socket.send(params)
      },
      close: function () {
          console.log("socket已经关闭")
      }
  },
  destroyed(){
        // 销毁监听
        this.socket.onclose = this.close
  },
  created(){
    this.init();
  }