def projectKey = getIssueContext().getProjectObject().getKey()
def issueTypeName = getIssueContext().getIssueType().getName()

def WSField = getFieldByName("Wiki Space Name")
def SKField = getFieldByName("Space Key")
def SAField = getFieldByName("Space Administrators")

if (issueTypeName == "Wiki Space Request")
{
    WSField.setHidden(false)
    WSField.setRequired(true)
    SKField.setHidden(false)
    SKField.setRequired(true)
    SAField.setHidden(false)
    SAField.setRequired(true)
}

else
 {
    WSField.setHidden(true)
    WSField.setRequired(false)
    SKField.setHidden(true)
    SKField.setRequired(false)
    SAField.setHidden(true)
    SAField.setRequired(false)
}