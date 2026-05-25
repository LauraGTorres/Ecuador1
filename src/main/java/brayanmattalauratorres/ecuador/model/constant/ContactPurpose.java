package brayanmattalauratorres.ecuador.model.constant;

public enum ContactPurpose {

    PURPOSE_SERVICE("Servicio"),
    PURPOSE_BUILDING_PROGRAM("Programa Edifica"),
    PURPOSE_SHOWS_AND_CONFERENCES("Conferencias");

    private final String visualName;
    ContactPurpose(String visualName){
        this.visualName = visualName;
    }

    public String getVisualName(){
        return visualName;
    }
}
