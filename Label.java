import greenfoot.*; 


public class Label extends Actor
{
    //Label class
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    
    private static final Color transparent = new Color(0,0,0,0);

    
   
    public Label(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
        updateImage();
    }
    
    
    public Label(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }
    
    public Label(GreenfootImage image, int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    public Label(GreenfootImage image, String value, int fontSize)
    {
        this(value, fontSize);
    }
    

    public Label(Label currentTheme, int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
        updateImage();
    }

    
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    

    
    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}