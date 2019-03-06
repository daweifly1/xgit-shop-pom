package com.xgit.bj.shop.generic.dao.mapper.base;

import java.util.List;

public abstract interface BaseItemMapper<V, D>
{
  public abstract int insertBatch(List<D> paramList);
  
  public abstract int delete(String paramString);
  
  public abstract List<D> list(String paramString);
}
