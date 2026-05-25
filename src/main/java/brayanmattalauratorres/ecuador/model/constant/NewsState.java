package brayanmattalauratorres.ecuador.model.constant;

public enum NewsState {
    PURPOSE_DRAFT("Borrador"),
    PURPOSE_PUBLISHED("Publicado");

    private final String visualName;
    NewsState(String visualName){
        this.visualName = visualName;
    }

    public String getVisualName(){
        return visualName;
    }
}
