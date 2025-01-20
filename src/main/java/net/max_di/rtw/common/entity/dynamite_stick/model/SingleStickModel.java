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

public class SingleStickModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "1x1"), "main");
    private final ModelPart bone;

    public SingleStickModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0837F, -4.25F, -0.9549F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-0.5837F, -9.25F, 0.0451F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9163F, 18.25F, -0.0451F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 4).addBox(-0.71F, -2.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0837F, 5.75F, 1.0451F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 5).addBox(0.5F, -2.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 6).addBox(0.5F, 5.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9163F, -1.25F, 0.0451F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 3).addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 4).addBox(-2.13F, 5.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9163F, -1.25F, -0.9549F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 3).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 4).addBox(0.0F, 5.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0837F, -1.25F, -0.9549F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 3).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0837F, -1.25F, 1.0451F, 0.0F, 2.3562F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
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