void call(){
    def nodeImage = config.node_image ?: "node:latest"
    def install_script = config.install_script ?: "install"
    def output_ls = config.ls_output ?: false
    docker.image(nodeImage).inside{
      unstash "workspace"
      sh "npm ${install_script}"
      stash name: "workspace", includes: "node_modules/**"
    }
}