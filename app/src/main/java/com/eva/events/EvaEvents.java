package com.eva.events;

import android.os.Bundle;

/**
 * Created by dell on 6/15/2015.
 */
public class EvaEvents {

    public static class UpdateActionBarTitleEvent{
        private final String title;
        private final String leftActionText;
        private final String rightActionText;
        private Class leftActionUiClass;
        private Class rightActionUiClass;

        public UpdateActionBarTitleEvent(String title, String leftActionText, String rightActionText){
            this.title = title;
            this.leftActionText = leftActionText;
            this.rightActionText = rightActionText;
        }

        public String getTitle() {
            return title;
        }

        public String getLeftActionText() {
            return leftActionText;
        }

        public String getRightActionText() {
            return rightActionText;
        }


        public void setLeftActionUiClass(Class leftActionUiClass){
            this.leftActionUiClass = leftActionUiClass;
        }

        public void setRightActionUiClass(Class rightActionUiClass){
            this.rightActionUiClass = rightActionUiClass;
        }

        public Class getLeftActionUiClass(){
            return leftActionUiClass;
        }

        public Class getRightActionUiClass(){
            return rightActionUiClass;
        }
    }

}
