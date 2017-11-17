Vagrant.configure("2") do |config|
   config.vm.box = "centos/7"
   config.vm.provider "virtualbox" do |v|
    v.memory = 2048
    v.cpus = 2
   end
   config.vm.define "ci" do |ci|
    ci.vm.network "forward_port", quest: 8080, host: 8080
    ci.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/ci-configuration.yml"
    end
   end
   config.vm.define "stage" do |stage|
   end
end
