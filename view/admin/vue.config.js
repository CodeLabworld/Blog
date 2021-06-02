module.exports = {

  devServer: {
    host: '0.0.0.0',
    port: 8080,
    proxy: {
      '/': {
        target: 'http://localhost:8099',
        changeOrigin: true,
        pathRewrite: {
          ['^/']: ''
        }
      }
    }
  }
}