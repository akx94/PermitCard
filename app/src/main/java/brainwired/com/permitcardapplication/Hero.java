package brainwired.com.permitcardapplication;

public class Hero {
    private String name, realName, team, firstAppearance, createdBy, publisher;

    public Hero(String name, String realName, String team, String firstAppearance, String createdBy, String publisher) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;


    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getPublisher() {
        return publisher;
    }


}

