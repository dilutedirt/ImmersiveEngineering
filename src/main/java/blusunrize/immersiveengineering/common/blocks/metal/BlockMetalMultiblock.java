/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package blusunrize.immersiveengineering.common.blocks.metal;

import blusunrize.immersiveengineering.api.IEProperties;
import blusunrize.immersiveengineering.common.blocks.BlockIEMultiblock;
import blusunrize.immersiveengineering.common.blocks.ItemBlockIEBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;

public class BlockMetalMultiblock extends BlockIEMultiblock
{
	TileEntityType<?> tileType;

	public BlockMetalMultiblock(String name, TileEntityType<?> te, IProperty<?>... additionalProperties)
	{
		super(name, Block.Properties.create(Material.IRON).hardnessAndResistance(3, 15),
				ItemBlockIEBase.class, ArrayUtils.addAll(additionalProperties,
						IEProperties.FACING_HORIZONTAL, IEProperties.MIRRORED));
		tileType = te;
		setNotNormalBlock();
		lightOpacity = 0;
	}

	@Nullable
	@Override
	public TileEntity createBasicTE(IBlockState state)
	{
		return tileType.create();
	}
}
