package com.app.gif.apicall.Domains;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Images {
    public Original original;
    public Prop downsized;
    public Prop downsized_large;
    public Prop downsized_medium;
    public Prop downsized_small;
    public Prop downsized_still;
    public Prop1 fixed_height;
    public Prop2 fixed_height_downsampled;
    public Prop1 fixed_height_small;
    public Prop fixed_height_small_still;
    public Prop fixed_height_still;
    public Prop1 fixed_width;
    public Prop2 fixed_width_downsampled;
    public Prop1 fixed_width_small;
    public Prop fixed_width_small_still;
    public Prop fixed_width_still;
    public Prop3 looping;
    public Prop original_still;
    public Prop4 original_mp4;
    public Prop4 preview;
    public Prop preview_gif;
    public Prop preview_webp;
    // public Prop 480w_still;
}
