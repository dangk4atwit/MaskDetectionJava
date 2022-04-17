package com.example.maskdetectionjava;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.google.common.util.concurrent.ListenableFuture;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class Mask extends AppCompatActivity {

    private Button button, red, green, exit;
    private TextView maskText;
    private int REQUEST_CODE_PERMISSION_CAMERA = 100;
    private String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mask_layout);

        button = (Button) findViewById(R.id.cameraButton);
        red = (Button) findViewById(R.id.btn_msk_not_detected);
        green = (Button) findViewById(R.id.btn_msk_detected);
        exit = (Button) findViewById(R.id.exit_camera);
        maskText = (TextView) findViewById(R.id.mask_detected_text);

        red.setOnClickListener(v -> {
                maskText.setTextColor(Color.RED);
                maskText.setText("Mask Not Found");
        });

        green.setOnClickListener(v -> {
                maskText.setTextColor(Color.GREEN);
                maskText.setText("Mask Found");
        });

        if(allPermissionsGranted()){
            startCameraPreview();
        }

        button.setOnClickListener(v -> {
            if(maskText.getText().equals("Mask Found")){
                Data.setMaskCleared(true);
                Toast.makeText(Mask.this, "Mask Verified", Toast.LENGTH_SHORT).show();
            }else{
                Data.setMaskCleared(false);
                Toast.makeText(Mask.this, "Mask Invalid", Toast.LENGTH_SHORT).show();
            }
            Intent maskintent = new Intent();
            maskintent.setClass(Mask.this, HomeMenu.class);
            startActivity(maskintent);
            finish();
        });

        exit.setOnClickListener(v -> {
            Intent maskintent = new Intent();
            maskintent.setClass(Mask.this, HomeMenu.class);
            startActivity(maskintent);
            finish();
        });
    }

    private boolean allPermissionsGranted(){
        for(String permission: REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(this,  permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    //Base code needs to be researched to properly incorporate into our camera implementation
//    private void takeImage(){
//        ImageCapture imageCapture = new ImageCapture.Builder().build();
//        imageCapture.takePicture(ContextCompat.getMainExecutor(), // Defines where the callbacks are run
//                ImageCapture.OnImageCapturedCallback({
//            override fun onCaptureSuccess(imageProxy: ImageProxy) {
//                val image: Image = imageProxy.image // Do what you want with the image
//                imageProxy.close() // Make sure to close the image
//            }
//
//            override fun onError(exception: ImageCaptureException) {
//                // Handle exception
//            }
//        })
//)
//    }

    void startCameraPreview() {
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture;

        ProcessCameraProvider cameraProvider = null;
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        try {
            cameraProvider = cameraProviderFuture.get();
        } catch(ExecutionException | InterruptedException e)  {}

        Preview preview = new Preview.Builder().build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_FRONT).build();

        PreviewView previewView = findViewById(R.id.cameraView);   //<<<<<<Returns null

        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        Camera camera = cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, preview);
    }
}