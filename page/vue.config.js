module.exports = {
    publicPath: "/",
    outputDir: "dist",
    lintOnSave: false,
    devServer: {
        host: "127.0.0.1",
        port: 8888,
        open: true,
        proxy: {
            '/': {
                target: "127.0.0.1:8080/api",
                changeOrigin: true
            }
        }
    }
}
