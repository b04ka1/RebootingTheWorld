package net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.max_di.rtw.RTW;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GingerbreadCreeperModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_creeper"), "main");
    private final ModelPart root;
    private final ModelPart rotate;
    private final ModelPart all;
    private final ModelPart body;
    private final ModelPart body_size;
    private final ModelPart head;
    private final ModelPart legs;
    private final ModelPart legs_front_right;
    private final ModelPart legs_front_left;
    private final ModelPart legs_back_right;
    private final ModelPart legs_back_right2;

    public GingerbreadCreeperModel(ModelPart root) {
        this.root = root.getChild("root");
        this.rotate = this.root.getChild("rotate");
        this.all = this.rotate.getChild("all");
        this.body = this.all.getChild("body");
        this.body_size = this.body.getChild("body_size");
        this.head = this.body.getChild("head");
        this.legs = this.all.getChild("legs");
        this.legs_front_right = this.legs.getChild("legs_front_right");
        this.legs_front_left = this.legs.getChild("legs_front_left");
        this.legs_back_right = this.legs.getChild("legs_back_right");
        this.legs_back_right2 = this.legs.getChild("legs_back_right2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition rotate = root.addOrReplaceChild("rotate", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition all = rotate.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.5F));

        PartDefinition body_size = body.addOrReplaceChild("body_size", CubeListBuilder.create().texOffs(13, 14).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition legs = all.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs_front_right = legs.addOrReplaceChild("legs_front_right", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.5F, -1.0F));

        PartDefinition legs_front_left = legs.addOrReplaceChild("legs_front_left", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.5F, -1.0F));

        PartDefinition legs_back_right = legs.addOrReplaceChild("legs_back_right", CubeListBuilder.create().texOffs(22, 10).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.5F, 2.0F));

        PartDefinition legs_back_right2 = legs.addOrReplaceChild("legs_back_right2", CubeListBuilder.create().texOffs(6, 20).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.5F, 2.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        root().getAllParts().forEach(ModelPart::resetPose);
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        this.animateWalk(GingerbreadCreeperAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((GingerbreadCreeperEntity) entity).idleAnimationState, GingerbreadCreeperAnimations.idle, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).sitDownAnimationState, GingerbreadCreeperAnimations.sit_down, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).sitAnimationState, GingerbreadCreeperAnimations.sit, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).standUpAnimationState, GingerbreadCreeperAnimations.stand_up, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).blowUpAnimationState, GingerbreadCreeperAnimations.explode_blink, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).dance1AnimationState, GingerbreadCreeperAnimations.dance, ageInTicks);
        this.animate(((GingerbreadCreeperEntity) entity).dance2AnimationState, GingerbreadCreeperAnimations.dance2, ageInTicks);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        root().render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}