Vagrant.configure("2") do |config|
   config.vm.box = "centos/7"
   config.vm.provider "virtualbox" do |v|
    v.memory = 2048
    v.cpus = 2
   end
   config.vm.define "ci" do |ci|
    ci.vm.network "private_network", ip: "192.168.0.1", virtualbox_intnet: "intenet"
    ci.vm.network "forwarded_port", guest: 8080, host: 8080
    ci.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/ci-configuration.yml"
      ansible.vault_password_file = "provisioning/.vault_pass"
      #ansible.verbose = "-vvv"
    end
   end
   config.vm.define "stage" do |stage|
     stage.vm.network "private_network", ip: "192.168.0.2", virtualbox_intnet: "intenet"
     stage.vm.network "forwarded_port", guest: 8080, host: 8081
     stage.vm.provision "ansible" do |ansible|
       ansible.playbook = "provisioning/stage-configuration.yml"
     end
   end
   config.vm.define "testci" do |testci|
     testci.vm.network "private_network", ip: "192.168.0.3", virtualbox_intnet: "intenet"
     testci.vm.network "forwarded_port", guest: 8080, host: 8082
     testci.vm.provision "ansible" do |ansible|
       ansible.playbook = "provisioning/testci-configuration.yml"
     end
   end
end
