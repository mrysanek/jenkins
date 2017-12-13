def _getJsonObjectPathFromString (String whichItem) {

    if (whichItem.toLower() == "environment")       return "MC.VM.Environment";
    if (whichItem.toLower() == "datacenter")        return "MC.VM.Datacenter";
    if (whichItem.toLower() == "os")                return "MC.VM.Type";
    if (whichItem.toLower() == "application")       return "MC.VM.Application";
    if (whichItem.toLower() == "owner")             return "MC.VM.Owner";
    if (whichItem.toLower() == "cpu")               return "cpu";
    if (whichItem.toLower() == "memory")            return "memory";
    if (whichItem.toLower() == "description")       return "description";
    if (whichItem.toLower() == "archivedays")       return "_archiveDays";
    if (whichItem.toLower() == "leasedays")         return "_leaseDays";
    if (whichItem.toLower() == "instancecount")     return "_number_of_instances";
    if (whichItem.toLower() == "net0profilename")   return "VirtualMachine.Network0.ProfileName";
    if (whichItem.toLower() == "net1profilename")   return "VirtualMachine.Network1.ProfileName";

    assert false : "Unknown friendly name requested from json path mapper - do not know \'" + whichItem + "\'"
       
}

def getItemFromTadJson(String friendlyName, String tadJson) {
    assert whichItem != "" : "This function requires an item name to parse from json"
    assert tadJson != "" : "This function requires a json string"
    def jsonObjectPath = _getJsonObjectPathFromString ( friendlyName )
    def jsonParser = new groovy.json.JsonSlurper()
    def tadObject = jsonParser.parseText(tadJson) 
    assert tadObject instanceof Map : "Unable to parse supplied json string (invalid json?)"
    assert tadObject.blueprint[jsonObjectPath] instanceof String : "Requested item has not returned a valid string type"
    return tadObject.blueprint[jsonObjectPath]
}

return this

