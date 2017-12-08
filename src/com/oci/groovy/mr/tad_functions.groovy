package com.oci.groovy.mr

def getItemFromBlueprint(String whichItem, String tadJson) {
    assert whichItem != "" : "This function requires an item name to parse from json"
    assert tadJson != "" : "This function requires a json string"

    def jsonObjectPath = ""
    switch(whichItem) {
        case "environment":     jsonObjectPath = "MC.VM.Environment"; break
        case "datacenter":      jsonObjectPath = "MC.VM.Datacenter"; break
        case "os":              jsonObjectPath = "MC.VM.Type"; break
        case "application":     jsonObjectPath = "MC.VM.Application"; break
        case "owner":           jsonObjectPath = "MC.VM.Owner"; break
        case "cpu":             jsonObjectPath = "cpu"; break
        case "memory":          jsonObjectPath = "memory"; break
        case "description":     jsonObjectPath = "description"; break
        case "archivedays":     jsonObjectPath = "_archiveDays"; break
        case "leasedays":       jsonObjectPath = "_leaseDays"; break
        case "instancecount":   jsonObjectPath = "_number_of_instances"; break
        case "net0profilename": jsonObjectPath = "VirtualMachine.Network0.ProfileName"; break
        case "net1profilename": jsonObjectPath = "VirtualMachine.Network1.ProfileName"; break
        default:
            assert false : "Unknown item requested from json parser"
        break
    }
    
    def jsonParser = new groovy.json.JsonSlurper()
    def tadObject = jsonParser.parseText(tadJson) 
    assert tadObject instanceof Map : "Unable to parse supplied json string (invalid json?)"
    assert tadObject.blueprint[jsonObjectPath] instanceof String : "Requested item has not returned a valid string type"
    return tadObject.blueprint[jsonObjectPath]
}

return this