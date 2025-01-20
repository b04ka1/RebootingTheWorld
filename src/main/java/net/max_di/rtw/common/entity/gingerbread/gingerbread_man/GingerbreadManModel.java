package net.max_di.rtw.common.entity.gingerbread.gingerbread_man;


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

public class GingerbreadManModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_man"), "main");
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart arm_r;
    private final ModelPart arm_l;
    private final ModelPart b1;
    private final ModelPart b2;
    private final ModelPart b3;
    private final ModelPart leg_base_l;
    private final ModelPart leg_l;
    private final ModelPart leg_base_r;
    private final ModelPart leg_r;

    public GingerbreadManModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
        this.arm_r = this.body.getChild("arm_r");
        this.arm_l = this.body.getChild("arm_l");
        this.b1 = this.body.getChild("b1");
        this.b2 = this.body.getChild("b2");
        this.b3 = this.body.getChild("b3");
        this.leg_base_l = this.root.getChild("leg_base_l");
        this.leg_l = this.leg_base_l.getChild("leg_l");
        this.leg_base_r = this.root.getChild("leg_base_r");
        this.leg_r = this.leg_base_r.getChild("leg_r");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 29).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 18).addBox(-4.0F, -8.0F, -1.5F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(36, 36).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(-2.0F, -4.0F, 0.0F));

        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(20, 41).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(2.0F, -4.0F, 0.0F));

        PartDefinition b1 = body.addOrReplaceChild("b1", CubeListBuilder.create().texOffs(12, 33).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(44, 36).addBox(0.0F, -10.0F, -2.5F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

        PartDefinition cube_r1 = b1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 6).mirror().addBox(-0.71F, -2.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(48, 6).mirror().addBox(-0.71F, -9.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = b1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 44).addBox(0.5F, -2.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(44, 48).addBox(0.5F, 5.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r3 = b1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 6).addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).addBox(-2.13F, 5.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = b1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 6).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).addBox(0.0F, 5.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition b2 = body.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(40, 48).addBox(-4.5F, -4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 45).addBox(0.0F, -4.0F, -4.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 0).addBox(0.0F, 3.0F, 2.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 3).addBox(0.0F, -4.0F, 2.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 46).addBox(0.0F, 3.0F, -4.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 35).addBox(2.5F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 48).addBox(2.5F, -4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(40, 48).addBox(-4.5F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.0F));

        PartDefinition cube_r5 = b2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 45).addBox(-0.71F, -2.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 43).addBox(-0.71F, 5.0F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, 2.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r6 = b2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 34).addBox(0.5F, -2.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(42, 28).addBox(0.5F, -9.0F, 0.71F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 5.0F, 1.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r7 = b2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 15).addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 12).addBox(-2.13F, -9.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 5.0F, -2.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r8 = b2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 15).addBox(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(36, 12).addBox(0.0F, -9.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 5.0F, -2.5F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r9 = b2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.0F, 1.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r10 = b2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(42, 20).addBox(-2.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.0F, -1.5F, 0.0F, 0.7854F, 0.0F));

        PartDefinition b3 = body.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(36, 44).addBox(-3.0F, -9.0F, -0.1F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).addBox(0.0F, -9.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 9).addBox(-1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 48).addBox(1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 28).addBox(1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 31).addBox(-1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -7.0F));

        PartDefinition cube_r11 = b3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(48, 31).addBox(-1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 28).addBox(1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 48).addBox(1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 9).addBox(-1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r12 = b3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-0.0087F, 3.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 48).addBox(-0.0087F, -4.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r13 = b3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 31).addBox(-1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 28).addBox(1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 48).addBox(1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 9).addBox(-1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r14 = b3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-0.0087F, 3.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 48).addBox(-0.0087F, -4.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

        PartDefinition cube_r15 = b3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(48, 31).addBox(-1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 28).addBox(1.5F, 3.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 48).addBox(1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 9).addBox(-1.5F, -4.0F, -6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r16 = b3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-0.0087F, 3.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 48).addBox(-0.0087F, -4.0F, -7.6582F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));

        PartDefinition cube_r17 = b3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-2.13F, -2.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 48).addBox(-2.13F, -9.0F, 0.12F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 5.0F, -4.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r18 = b3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(32, 0).addBox(-0.77F, -4.0F, -4.7F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r19 = b3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(20, 29).addBox(-2.05F, -4.0F, -2.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leg_base_l = root.addOrReplaceChild("leg_base_l", CubeListBuilder.create(), PartPose.offset(1.0F, 8.0F, -1.0F));

        PartDefinition leg_l = leg_base_l.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(42, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition leg_base_r = root.addOrReplaceChild("leg_base_r", CubeListBuilder.create(), PartPose.offset(-1.0F, 8.0F, -1.0F));

        PartDefinition leg_r = leg_base_r.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(28, 41).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        switch (((GingerbreadManEntity) entity).getExplosionLevel()) {
            case 0:
                this.animateWalk(GingerbreadManAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
                this.animate(((GingerbreadManEntity) entity).idleAnimationState, GingerbreadManAnimations.idle, ageInTicks, 1f);
                break;
            case 1:
                this.animateWalk(GingerbreadManAnimations.b1, limbSwing, limbSwingAmount, 1f, 2.5f);
                this.animate(((GingerbreadManEntity) entity).idleAnimationState, GingerbreadManAnimations.idleb1, ageInTicks, 1f);
                break;
            case 2:
                this.animateWalk(GingerbreadManAnimations.b2, limbSwing, limbSwingAmount, 1f, 2.5f);
                this.animate(((GingerbreadManEntity) entity).idleAnimationState, GingerbreadManAnimations.idleb2, ageInTicks, 1f);
                break;
            case 3:
                this.animateWalk(GingerbreadManAnimations.b3, limbSwing, limbSwingAmount, 1f, 2.5f);
                this.animate(((GingerbreadManEntity) entity).idleAnimationState, GingerbreadManAnimations.idleb3, ageInTicks, 1f);
                break;
            default:
                break;
        }
        this.animate(((GingerbreadManEntity) entity).sitDownAnimationState, GingerbreadManAnimations.sit_down, ageInTicks, 1f);
        this.animate(((GingerbreadManEntity) entity).sitAnimationState, GingerbreadManAnimations.sit, ageInTicks, 1f);
        this.animate(((GingerbreadManEntity) entity).standUpAnimationState, GingerbreadManAnimations.sit_up, ageInTicks, 1f);
        this.animate(((GingerbreadManEntity) entity).dance1AnimationState, GingerbreadManAnimations.dance1, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }


    @Override
    public ModelPart root() {
        return root;
    }
}