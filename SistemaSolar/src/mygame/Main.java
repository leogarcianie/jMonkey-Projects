package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    public Spatial spatial_var = null;
    public Spatial sol_spatial = null;
    public Spatial planeta1_spatial = null;
    public Spatial planeta2_spatial = null;
    public Spatial planeta3_spatial = null;
    public Spatial planeta4_spatial = null;
    public Spatial planeta5_spatial = null;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Node padre_cubo = new Node("padre_cubo");
        Sphere s = new Sphere(128, 128, 1f);
        
        Geometry sol_geom = new Geometry("sol_geom", s);
        Geometry planeta1_geom = new Geometry("planeta1_geom", s);
        Geometry planeta2_geom = new Geometry("planeta2_geom", s);
        Geometry planeta3_geom = new Geometry("planeta3_geom", s);
        Geometry planeta4_geom = new Geometry("planeta4_geom", s);
        Geometry planeta5_geom = new Geometry("planeta5_geom", s);
        
        Material mat_amarillo = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_amarillo.setColor("Color", ColorRGBA.Yellow);
        Material mat_magenta = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_magenta.setColor("Color", ColorRGBA.Magenta);
        Material mat_azul = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_azul.setColor("Color", ColorRGBA.Blue);
        Material mat_cyan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_cyan.setColor("Color", ColorRGBA.Cyan);
        Material mat_verde = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_verde.setColor("Color", ColorRGBA.Green);
        Material mat_naranja = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_naranja.setColor("Color", ColorRGBA.Orange);
        
        sol_geom.setMaterial(mat_amarillo);
        planeta1_geom.setMaterial(mat_magenta);
        planeta2_geom.setMaterial(mat_azul);
        planeta3_geom.setMaterial(mat_cyan);
        planeta4_geom.setMaterial(mat_verde);
        planeta5_geom.setMaterial(mat_naranja);
        
        padre_cubo.attachChild(sol_geom);
        padre_cubo.attachChild(planeta1_geom);
        padre_cubo.attachChild(planeta2_geom);
        padre_cubo.attachChild(planeta3_geom);
        padre_cubo.attachChild(planeta4_geom);
        padre_cubo.attachChild(planeta5_geom);
        
        sol_geom.scale(1.5f);
        sol_geom.move(0,0,0);
        
        planeta1_geom.move(3, -1, 3);
        planeta1_geom.scale(0.7f);
        planeta2_geom.move(-4, 0, 1);
        planeta2_geom.scale(0.8f);
        planeta3_geom.move(-3, -0.2f, -4);
        planeta3_geom.scale(0.6f);
        planeta4_geom.move(3, 0.2f, 5);
        planeta4_geom.scale(0.5f);
        planeta5_geom.move(-2, 0.1f, -6);
        planeta5_geom.scale(0.6f);
               
        rootNode.attachChild(padre_cubo);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if(spatial_var == null){
            spatial_var = rootNode.getChild("padre_cubo");
            sol_spatial = rootNode.getChild("sol_geom");
            planeta1_spatial = rootNode.getChild("planeta1_geom");
            planeta2_spatial = rootNode.getChild("planeta2_geom");
            planeta3_spatial = rootNode.getChild("planeta3_geom");
            planeta4_spatial = rootNode.getChild("planeta4_geom");
            planeta5_spatial = rootNode.getChild("planeta5_geom");
        }
        
        spatial_var.rotate(0, tpf/4, 0);
        sol_spatial.rotate(0, -(tpf*2), 0);
        planeta1_spatial.rotate(0, tpf, 0);
        planeta2_spatial.rotate(0, tpf*2, 0);
        planeta3_spatial.rotate(0, tpf*0.5f, 0);
        planeta4_spatial.rotate(0, tpf+3, 0);
        planeta5_spatial.rotate(0, -tpf+3, 0);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
