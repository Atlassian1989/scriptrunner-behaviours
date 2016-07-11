//Initialiser for POPS JIRA Project
//behaviour groovy script
def projectKey = getIssueContext().getProjectObject().getKey()
def issueTypeName = getIssueContext().getIssueType().getName()

def sField = getFieldByName("Sprint")
def tField = getFieldById("timetracking_originalestimate")
def rField = getFieldById("timetracking_remainingestimate")
//def dfield = getFieldById("description")
//def gpridfield = getFieldById("Gogo PMO Request ID")
def epicLink = getFieldByName("Epic Link")

sField.setHidden(true)
tField.setHidden(true)
rField.setHidden(true)
//gpridfield.setHidden(true)
epicLink.setHidden(true)