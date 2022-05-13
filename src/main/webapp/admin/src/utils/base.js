const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmvd34b/",
            name: "ssmvd34b",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmvd34b/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "在线学习平台小程序"
        } 
    }
}
export default base
