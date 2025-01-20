package net.max_di.rtw.common.entity.dynamite_stick.model;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.max_di.rtw.RTW;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StickModel9x9<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "9x9"), "main");
    private final ModelPart group;
    private final ModelPart bone;

    public StickModel9x9(ModelPart root) {
        this.group = root.getChild("group");
        this.bone = this.group.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create().texOffs(12, 30).addBox(-2.983F, -3.4F, -0.0449F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(0.017F, -3.4F, -2.9449F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.983F, 0.6F, -3.9449F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.017F, 13.4F, -1.0551F));

        PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 18).addBox(-0.77F, -4.0F, -4.7F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.017F, 0.6F, 1.0551F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-2.05F, -4.0F, -2.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.017F, 0.6F, -2.9449F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone = group.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(32, 6).addBox(-9.5F, -9.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 9).addBox(-6.5F, -9.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 12).addBox(-9.5F, -2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 15).addBox(-6.5F, -2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 18).addBox(-9.5F, -2.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 21).addBox(-6.5F, -2.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 24).addBox(-6.5F, -9.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 27).addBox(-9.5F, -9.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 34).addBox(-4.0F, -9.0F, 8.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 34).addBox(-4.0F, -9.0F, 5.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 34).addBox(-4.0F, -2.0F, 8.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(28, 34).addBox(-4.0F, -2.0F, 5.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 34).addBox(-14.0F, -9.0F, 8.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 35).addBox(-14.0F, -9.0F, 5.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 35).addBox(-14.0F, -2.0F, 8.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 35).addBox(-14.0F, -2.0F, 5.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.017F, 10.6F, -6.9449F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 33).addBox(-0.71F, -2.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 30).addBox(-0.71F, -9.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, 11.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 33).addBox(0.5F, -2.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(28, 33).addBox(0.5F, -9.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 10.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 30).addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 30).addBox(-2.13F, -9.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 3).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(0.0F, -9.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.group.yRot = ageInTicks * 16.0F * (float) (Math.PI / 180.0);
        this.group.xRot = -ageInTicks * 16.0F * (float) (Math.PI / 180.0);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        group.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }
}