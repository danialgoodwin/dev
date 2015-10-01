package com.danialgoodwin.game.martianrunsample.box2d;

import com.danialgoodwin.game.martianrunsample.enums.UserDataType;

public class GroundUserData extends UserData {

    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }

}
