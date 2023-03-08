const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    host: 'localhost',
    port: 5000,
    proxy: {
      '/backend': {
        ws: false,
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: { '^/backend': '' }
      }
    }
  }
})