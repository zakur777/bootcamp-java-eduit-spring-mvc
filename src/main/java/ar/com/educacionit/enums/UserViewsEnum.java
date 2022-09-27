package ar.com.educacionit.enums;

public enum UserViewsEnum {
    LIST("user/list"),
    EDIT("user/edit"),
    NEW("user/new"),
    LIST_REDIRECT("redirect:cupon/list"),
    ;

    private String view;

    private UserViewsEnum(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
