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

public class QuadrupleStickModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "4x4"), "main");
    private final ModelPart bone;

    public QuadrupleStickModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5081F, -4.2632F, -2.4684F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 6).addBox(-0.0081F, -3.2632F, -4.4684F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).mirror().addBox(-0.0081F, 3.7368F, 2.5316F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(20, 0).addBox(-0.0081F, -3.2632F, 2.5316F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 6).addBox(-0.0081F, 3.7368F, -4.4684F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(2.4919F, 3.7368F, 0.0316F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(2.4919F, -3.2632F, 0.0316F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(-4.5081F, 3.7368F, 0.0316F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(-4.5081F, -3.2632F, 0.0316F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5081F, 18.2632F, 1.4684F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 3).addBox(-0.71F, -2.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-0.71F, 5.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5081F, -1.2632F, 2.5316F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 9).addBox(0.5F, -2.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(0.5F, -9.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4919F, 5.7368F, 1.5316F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 15).addBox(-2.13F, -9.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4919F, 5.7368F, -2.4684F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 15).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 18).addBox(0.0F, -9.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5081F, 5.7368F, -2.4684F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 15).addBox(-2.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4919F, -4.2632F, 1.5316F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4919F, -4.2632F, -1.4684F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bone.yRot = ageInTicks * 16.0F * (float) (Math.PI / 180.0);
        this.bone.xRot = -ageInTicks * 16.0F * (float) (Math.PI / 180.0);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        bone.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }
}