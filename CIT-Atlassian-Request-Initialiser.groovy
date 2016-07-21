// Behavior for initialiser for CIT JIRA Project
//---------------------------------------------------//
import com.atlassian.jira.component.ComponentAccessor

def customFieldManager = ComponentAccessor.getCustomFieldManager()
def optionsManager = ComponentAccessor.getOptionsManager()

def crField = getFieldByName("Change Request")
def formField = getFieldByName("Application Component") // *name* of your custom field
def customField = customFieldManager.getCustomFieldObject(formField.getFieldId())
def config = customField.getRelevantConfig(getIssueContext())
def options = optionsManager.getOptions(config)


def projectKey = getIssueContext().getProjectObject().getKey()
def issueTypeName = getIssueContext().getIssueType().getName()

def WSField = getFieldByName("Wiki Space Name")
def SKField = getFieldByName("Space Key")
def SAField = getFieldByName("Space Administrators")
def TJRField =  getFieldByName("Type of JIRA Request")

if (issueTypeName == "SharePoint / Wiki Site Request")
{
    def optionsMap = options.findAll {
    it.value in ["Confluence", "SharePoint"] // list of options you want to show
}.collectEntries {
    [
        (it.optionId.toString()) : it.value
    ]
}
formField.setFieldOptions(optionsMap)
formField.setRequired(true)
TJRField.setHidden(true)
TJRField.setRequired(false)
crField.setHidden(true)
crField.setRequired(false)
}

else if (issueTypeName == "JIRA Request")
 {
    def optionsMap = options.findAll {
    it.value in ["Jira"] // list of options you want to show
}.collectEntries {
    [
        (it.optionId.toString()) : it.value
    ]
}
formField.setFieldOptions(optionsMap)
formField.setRequired(true)
TJRField.setHidden(false)
TJRField.setRequired(true)
}

else if (issueTypeName == "Atlassian Plugin Request")
 {
         def optionsMap = options.findAll {
    it.value in ["Confluence","Jira"]
    }.collectEntries {
    [
        (it.optionId.toString()) : it.value
    ]
 }
formField.setFieldOptions(optionsMap)
formField.setRequired(true)
    }
else 
 {
     def optionsMap = options.findAll {
    it.value in ["SharePoint","Confluence","ePurchase", "eContract","Jira","O365","ADP","OrgChart"] // list of options you want to show
    }.collectEntries {
    [
        (it.optionId.toString()) : it.value
    ]
 }
formField.setFieldOptions(optionsMap)
formField.setRequired(false)
TJRField.setHidden(true)
TJRField.setRequired(false)
crField.setHidden(true)
crField.setRequired(false)
}
//----------------------------------------------------------------------------------------//
// Behavior for field Type of JIRA Request
//-----------------------------------------------------------------------------------------//
    import com.atlassian.jira.component.ComponentAccessor


def NPField = getFieldByName("Name of Project")
def PKField =getFieldByName("Project Key")
def PCField = getFieldByName("Project Category")
def PRBField = getFieldByName("Does this Project Require a Board?")
def ADField = getFieldByName("Administrators")

def crField = getFieldByName("Change Request")

def fvField = getFieldById("fixVersions")
def sField = getFieldByName("Sprint")
def tField = getFieldById("timetracking_originalestimate")
def rField = getFieldById("timetracking_remainingestimate")
def SPField = getFieldByName("Story Points")

def TJRField = getFieldById(getFieldChanged())
def selectedOption = TJRField.getValue() as String

if ((selectedOption == null))
{
    NPField.setHidden(true)
    NPField.setRequired(false)
    PKField.setHidden(true)
    PKField.setRequired(false)
    NPField.setRequired(false)
    PCField.setHidden(true)
    PCField.setRequired(false)
    PRBField.setHidden(true)
    PRBField.setRequired(false)
    ADField.setHidden(true)
    ADField.setRequired(false)
    crField.setHidden(true)
    crField.setRequired(false)
}
else if (selectedOption == "JIRA - Project Change Request")
{
 crField.setHidden(false)
 crField.setRequired(true)
    NPField.setHidden(false)
    NPField.setRequired(true)
    PKField.setHidden(false)
    NPField.setRequired(true)
    PCField.setHidden(true)
    PCField.setRequired(false)
    PRBField.setHidden(true)
    PRBField.setRequired(false)
    ADField.setHidden(true)
    ADField.setRequired(false)
  }  
else if ((selectedOption.contains("New Project Request")))
{
    NPField.setHidden(false)
    NPField.setRequired(true)
    PKField.setHidden(false)
    PKField.setRequired(true)
    PCField.setHidden(false)
    PCField.setRequired(true)
    PRBField.setHidden(false)
    PRBField.setRequired(true)
    ADField.setHidden(false)
    ADField.setRequired(true)
    crField.setHidden(true)
    crField.setRequired(false)
}
else 
 {
    NPField.setHidden(true)
    NPField.setRequired(false)
    PKField.setHidden(true)
    PKField.setRequired(false)
    NPField.setRequired(false)
    PCField.setHidden(true)
    PCField.setRequired(false)
    PRBField.setHidden(true)
    PRBField.setRequired(false)
    ADField.setHidden(true)
    ADField.setRequired(false)
    crField.setHidden(true)
    crField.setRequired(false)
 }

//-------------------------------------------------------------------------------------------//
//Behavior for field Application Component//
//--------------------------------------------------------------------------------------------//
//Other fields
def NPField = getFieldByName("Name of Project")
def PKField =getFieldByName("Project Key")
def PCField = getFieldByName("Project Category")
def PRBField = getFieldByName("Does this Project Require a Board?")
def ADField = getFieldByName("Administrators")
//Wiki Fields
def WSField = getFieldByName("Wiki Space Name")
def SKField = getFieldByName("Space Key")
def SAField = getFieldByName("Space Administrators")

//SharePoint Fields
def STField = getFieldByName("Site Title")
def SNField = getFieldByName("Site Name")
def SOField = getFieldByName("Site Owner")

//Change Request Field
def CRField = getFieldByName("Change Request")

//Behavior Field
def AField = getFieldById(getFieldChanged())
def selectedOption = AField.getValue() as String

if (selectedOption == "Confluence")
{
    WSField.setHidden(false)
    WSField.setRequired(true)
    SKField.setHidden(false)
    SKField.setRequired(true)
    SAField.setHidden(false)
    SAField.setRequired(true)
    
    STField.setHidden(true)
    STField.setRequired(false)
    SNField.setHidden(true)
    SNField.setRequired(false)
    SOField.setHidden(true)
    SOField.setRequired(false)
    
    CRField.setHidden(true)
    CRField.setRequired(false)
    
    NPField.setHidden(true)
    NPField.setRequired(false)
    PKField.setHidden(true)
    PKField.setRequired(false)
    PCField.setHidden(true)
    PCField.setRequired(false)
    PRBField.setHidden(true)
    PRBField.setRequired(false)
    ADField.setHidden(true)
    ADField.setRequired(false)
 }
else if (selectedOption == "SharePoint")
 {
    STField.setHidden(false)
    STField.setRequired(true)
    SNField.setHidden(false)
    SNField.setRequired(true)
    SOField.setHidden(false)
    SOField.setRequired(true)
    
     //
    WSField.setHidden(true)
    WSField.setRequired(false)
    SKField.setHidden(true)
    SKField.setRequired(false)
    SAField.setHidden(true)
    SAField.setRequired(false)
     
     NPField.setHidden(true)
    NPField.setRequired(false)
    PKField.setHidden(true)
    PKField.setRequired(false)
    PCField.setHidden(true)
    PCField.setRequired(false)
    PRBField.setHidden(true)
    PRBField.setRequired(false)
    ADField.setHidden(true)
    ADField.setRequired(false)
    
    CRField.setHidden(true)
    CRField.setRequired(false)
 }

else
    {
    STField.setHidden(true)
    STField.setRequired(false)
    SNField.setHidden(true)
    SNField.setRequired(false)
    SOField.setHidden(true)
    SOField.setRequired(false)
    WSField.setHidden(true)
    WSField.setRequired(false)
    SKField.setHidden(true)
    SKField.setRequired(false)
    SAField.setHidden(true)
    SAField.setRequired(false)
    CRField.setHidden(false)
    //Enable thsi for JIRA Change Request
        //CRField.setRequired(false)
    }
//-----------------------------------------------------------------------------------//
//Behavior for field Change Request//
//-----------------------------------------------------------------------------------//
import com.atlassian.jira.component.ComponentAccessor

def jpField = getFieldByName("JIRA Project")
def urlField = getFieldByName("GitLab URL")
def aurlField = getFieldByName("Additional URL's / Notes")

def fvField = getFieldById("fixVersions")
def sField = getFieldByName("Sprint")
def tField = getFieldById("timetracking_originalestimate")
def rField = getFieldById("timetracking_remainingestimate")
def SPField = getFieldByName("Story Points")

def crField = getFieldById(getFieldChanged())
def selectedOption = crField.getValue() as String

if ((selectedOption.contains("GIT Repositories")))
{
    urlField.setHidden(false)
    urlField.setRequired(true)
    aurlField.setHidden(false)
    aurlField.setRequired(true)
    jpField.setHidden(false)
    jpField.setRequired(true)
    
    fvField.setHidden(true)
    sField.setHidden(true)
    tField.setHidden(true)
    rField.setHidden(true)
    SPField.setHidden(true)
  
}
else
{
    urlField.setHidden(true)
    urlField.setRequired(false)
    aurlField.setHidden(true)
    aurlField.setRequired(false)
    jpField.setHidden(true)
    jpField.setRequired(false)
    
    fvField.setHidden(true)
    sField.setHidden(true)
    tField.setHidden(true)
    rField.setHidden(true)
    SPField.setHidden(true)
}
//---------------------------------------------------------------------------------------//
