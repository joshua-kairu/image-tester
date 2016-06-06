package com.jlt.imagetester;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 *
 * Image Tester
 * <p/>
 * Tutorial for showcasing proper use of images in Material Design
 * <p/>
 * Copyright (C) 2016 Kairu Joshua Wambugu
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 */

// begin activity MainActivity
public class MainActivity extends AppCompatActivity {

    /** CONSTANTS */

    /** VARIABLES */

    /* Image Views */

    @InjectView( R.id.am_iv )
    ImageView photoImageView; // the image of the photo

    /* Matrix */

    private Matrix imageTranslationMatrix; // matrix to be used to translate the image

    /* Radio Buttons */

    @InjectView( R.id.am_rb_none )
    RadioButton noneRadioButton; // radio button for when an ill-sized image manipulation is done

    @InjectView( R.id.am_rb_center )
    RadioButton centerRadioButton; // radio button for when an the image is to be centered

    @InjectView( R.id.am_rb_center_crop )
    RadioButton centerCropRadioButton; // radio button for when an the image is to be centered and cropped

    @InjectView( R.id.am_rb_center_inside )
    RadioButton centerInsideRadioButton; // radio button for when an the image is to be centered inside

    @InjectView( R.id.am_rb_fit_center )
    RadioButton fitCenterRadioButton; // radio button for when an the image is to be fit at center

    @InjectView( R.id.am_rb_fit_end )
    RadioButton fitEndRadioButton; // radio button for when an the image is to be fit at an end

    @InjectView( R.id.am_rb_fit_start )
    RadioButton fitStartRadioButton; // radio button for when an the image is to be fit at a start

    @InjectView( R.id.am_rb_fit_XY )
    RadioButton fitXYRadioButton; // radio button for when an the image is to be fit on the X and Y of its host image view

    @InjectView( R.id.am_rb_matrix )
    RadioButton matrixRadioButton; // radio button for when an the image is to be manipulated using a matrix

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the activity main layout
        // 2. bind views
        // 3. start with the fit center button checked
        // 4. initialize the matrix
        // 4a. it should scale an image by 50% and
        // 4b. move the image right and bottom by 100 units

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the activity main layout

        setContentView( R.layout.activity_main );

        // 2. bind views

        ButterKnife.inject( this );

        // 3. start with the fit center button checked

        fitCenterRadioButton.setChecked( true );

        // 4. initialize the matrix

        imageTranslationMatrix = new Matrix();

        // 4a. it should scale an image by 50% and

        // postScale - Postconcats the matrix with the specified translation. M' = T(dx, dy) * M
        imageTranslationMatrix.postScale( 0.5f, 0.5f );

        // 4b. move the image right and bottom by 100 units

        // postTranslate - Postconcats the matrix with the specified translation. M' = T(dx, dy) * M
        imageTranslationMatrix.postTranslate( 100, 100 );


    } // end onCreate

    /**
     * Other Methods
     */

    // begin method getSelectedRadioButton
    // returns the selected radio button
    private RadioButton getSelectedRadioButton( View checkedRadioButtonView ) {

        // 0. create an array of all radio buttons
        // 1. go through that array
        // 1a. if there is a radio button that is checked and is not the parameter checked view
        // 1a1. return that radio
        // 1b. else return null

        // 0. create an array of all radio buttons

        RadioButton[] radioButtons =
                {
                        centerRadioButton,
                        centerCropRadioButton,
                        centerInsideRadioButton,
                        fitCenterRadioButton,
                        fitEndRadioButton,
                        fitStartRadioButton,
                        fitXYRadioButton,
                        fitXYRadioButton,
                        matrixRadioButton,
                        noneRadioButton
                };

        // 1. go through that array

        // begin enhanced for through the radio buttons array
        for ( RadioButton radioButton : radioButtons ) {

            // 1a. if there is a radio button that is checked and is not the parameter checked view
            // 1a1. return that radio

            // 1a. if there is a radio button that is checked and is not the parameter checked view
            // 1a1. return that radio

            if ( radioButton.isChecked() == true && radioButton != checkedRadioButtonView ) { return radioButton; }

        } // end enhanced for through the radio buttons array

        // 1b. else return null

        return null;

    } // end method getSelectedRadioButton

    // begin method uncheckOtherRadioButtons
    // deselects all other radios except the one passed in
    private void uncheckOtherRadioButtons( RadioButton checkedRadioButton ) {

        // 0. create an array of all radio buttons
        // 1. go through that array
        // 1a. uncheck all radios not the checked radio

        // 0. create an array of all radio buttons

        RadioButton[] radioButtons =
                {
                        centerRadioButton,
                        centerCropRadioButton,
                        centerInsideRadioButton,
                        fitCenterRadioButton,
                        fitEndRadioButton,
                        fitStartRadioButton,
                        fitXYRadioButton,
                        fitXYRadioButton,
                        matrixRadioButton,
                        noneRadioButton
                };

        // 1. go through that array

        // begin enhanced for through the array
        for( RadioButton radioButton : radioButtons ) {

            // 1a. uncheck all radios not the checked radio

            // 1a. uncheck all radios not the checked radio

            if ( radioButton.equals(  checkedRadioButton ) == false ) { radioButton.setChecked( false ); }

        } // end enhanced for through the array

    } // end method deselectOtherRadioButtons

    // begin method onClickRadioButton
    @OnClick(
            {
                    R.id.am_rb_center,
                    R.id.am_rb_center_crop,
                    R.id.am_rb_center_inside,
                    R.id.am_rb_fit_center,
                    R.id.am_rb_fit_end,
                    R.id.am_rb_fit_start,
                    R.id.am_rb_fit_XY,
                    R.id.am_rb_matrix,
                    R.id.am_rb_none
            }
    )
    void onClickRadioButton( RadioButton checkedRadioButton ) {

        // 0. get the currently checked radio
        // 1. if the currently checked radio is not the parameter checked radio button
        // 1a. uncheck the currently checked radio
        // 1b. else the currently checked radio is the parameter checked radio so do nothing
        // 2. set the photo to have no padding
        // 3. if the no radio has been selected
        // 3a. make the image have a 32 dp padding
        // 3b. fit image to center
        // 3c. check the selected radio
        // 3d. uncheck other radios
        // 4. if the center radio is selected
        // 4a. scale the image to center
        // 4b. check the selected radio
        // 4c. uncheck other radios
        // 5. if the center crop radio is selected
        // 5a. scale the image to center crop
        // 5b. check the selected radio
        // 5c. uncheck other radios
        // 6. if the center inside radio is selected
        // 6a. scale the image to center inside
        // 6b. check the selected radio
        // 6c. uncheck other radios
        // 7. if the fit center radio is selected
        // 7a. scale the image to fit center
        // 7b. check the selected radio
        // 7c. uncheck other radios
        // 8. if the fit end radio is selected
        // 8a. scale the image to fit end
        // 8b. check the selected radio
        // 8c. uncheck other radios
        // 9. if the fit start radio is selected
        // 9a. scale the image to fit start
        // 9b. check the selected radio
        // 9c. uncheck other radios
        // 10. if the fit XY radio is selected
        // 10a. scale the image to fit XY
        // 10b. check the selected radio
        // 10c. uncheck other radios
        // 11. if the matrix radio is selected
        // 11a. scale the image to matrix
        // 11b. scale the image using the matrix
        // 11c. check the selected radio
        // 11d. uncheck other radios

        // 0. get the currently checked radio

        RadioButton currentlyCheckedRadio = getSelectedRadioButton( checkedRadioButton );

        // 1. if the currently checked radio is not the parameter checked radio button

        // 1a. uncheck the currently checked radio

        if ( currentlyCheckedRadio != null && currentlyCheckedRadio != checkedRadioButton ) { checkedRadioButton.setChecked( false ); }

        // 1b. else the currently checked radio is the parameter checked radio so do nothing

        // 2. set the photo to have no padding

        // units of padding are in pixels
        photoImageView.setPadding( 0, 0, 0, 0 );

        // begin switch to know which radio has been selected
        switch ( ( String ) checkedRadioButton.getText() ) {

            // 3. if the no radio has been selected

            // case for NO!!!
            case "NO!!!":

                // 3a. make the image have a 32 dp padding

                int paddingPx = dpToPx( 32 );

                // 3b. fit image to center

                photoImageView.setPadding( paddingPx, paddingPx, paddingPx, paddingPx );

                photoImageView.setScaleType( ImageView.ScaleType.FIT_CENTER );

                // 3c. check the selected radio

                checkedRadioButton.setChecked( true );

                // 3d. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 4. if the center radio is selected

            // case for CENTER
            case "CENTER":

                // 4a. scale the image to center

                photoImageView.setScaleType( ImageView.ScaleType.CENTER );

                // 4b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 4c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 5. if the center crop radio is selected

            // case CENTER_CROP
            case "CENTER_CROP":

                // 5a. scale the image to center crop

                photoImageView.setScaleType( ImageView.ScaleType.CENTER_CROP );

                // 5b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 5c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 6. if the center inside radio is selected

            // case CENTER_INSIDE
            case "CENTER_INSIDE":

                // 6a. scale the image to center inside

                photoImageView.setScaleType( ImageView.ScaleType.CENTER_INSIDE );

                // 6b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 6c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 7. if the fit center radio is selected

            // case FIT_CENTER
            case "FIT_CENTER":

                // 7a. scale the image to fit center

                photoImageView.setScaleType( ImageView.ScaleType.FIT_CENTER );

                // 7b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 7c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 8. if the fit end radio is selected

            // case FIT_END
            case "FIT_END":

                // 8a. scale the image to fit end

                photoImageView.setScaleType( ImageView.ScaleType.FIT_END );

                // 8b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 8c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 9. if the fit start radio is selected

            // case FIT_START
            case "FIT_START":

                // 9a. scale the image to fit start

                photoImageView.setScaleType( ImageView.ScaleType.FIT_START );

                // 9b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 9c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 10. if the fit XY radio is selected

            // case FIT_XY
            case "FIT_XY":

                // 10a. scale the image to fit XY

                photoImageView.setScaleType( ImageView.ScaleType.FIT_XY );

                // 10b. check the selected radio

                checkedRadioButton.setChecked( true );

                // 10c. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

            // 11. if the matrix radio is selected

            // case MATRIX
            case "MATRIX":

                // 11a. scale the image to matrix

                photoImageView.setScaleType( ImageView.ScaleType.MATRIX );

                // 11b. scale the image using the matrix

                photoImageView.setImageMatrix( imageTranslationMatrix );

                // 11c. check the selected radio

                checkedRadioButton.setChecked( true );

                // 11d. uncheck other radios

                uncheckOtherRadioButtons( checkedRadioButton );

                break;

        } // end switch to know which radio has been selected

    } // end method onClickRadioButton

    // begin method dpToPx
    // converts dps to pixels
    public static int dpToPx( int dp ) {

        // 0. 1 pixel = 1 dp * pixel density

        // 0. 1 pixel = 1 dp * pixel density

        // getSystem - only system resources
        // .density - The logical density of the display.
        return ( int ) ( dp * Resources.getSystem().getDisplayMetrics().density );

    } // end method dpToPx

} // end activity MainActivity