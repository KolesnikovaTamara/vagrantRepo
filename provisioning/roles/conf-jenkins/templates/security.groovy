#!groovy
import hudson.security.*
import jenkins.model.*

def user = hudson.model.User.get("admin");
def password = hudson.security.HudsonPrivateSecurityRealm.Details.fromPlainPassword('{{ jenkins_admin_password }}')
user.addProperty(password)
user.save()

