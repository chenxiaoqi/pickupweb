module.exports = function (grunt) {

    grunt.initConfig({

        pkg: grunt.file.readJSON("package.json"),

        uglify: {
            options: {
                stripBanners: true,
                banner: '/* pickup web */\n',
                sourceMap: true,
                sourceMapIncludeSources: true,
                sourceMapName: 'target/build/runtime.min.js.map'
            },
            files:{
                "target/build/runtime.min.js.map":[
                    "src/main/resources/public/js/test.js"
                ]
            },
            build:{
                src: "src/main/resources/public/js/*.js",
                dest:"target/build/<%=pkg.name%>-<%=pkg.version%>.min.js"
            }
        }

    });

    grunt.loadNpmTasks('grunt-contrib-uglify');

    grunt.registerTask("default", ["uglify"]);



};